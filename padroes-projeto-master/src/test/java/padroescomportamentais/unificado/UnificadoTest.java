package padroescomportamentais.unificado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PipelineETLTest {

    private EtapaPipeline pipeline;
    private PersistidorDados etapaPersistencia;

    @BeforeEach
    void setUp() {
        EtapaPipeline validador = new ValidadorFormato();
        EtapaPipeline seguranca = new VerificadorSeguranca();
        EtapaPipeline processador = new ProcessadorDados();
        etapaPersistencia = new PersistidorDados(new PersistenciaBancoStrategy());

        validador.setProxima(seguranca)
                .setProxima(processador)
                .setProxima(etapaPersistencia);

        this.pipeline = validador;
    }

    @Test
    void deveProcessarArquivoCSVESalvarNoBanco() {
        ItemDado dado = new ItemDado("dados.csv", "item1,item2,item3");
        boolean sucesso = pipeline.executar(dado);
        assertTrue(sucesso);
        assertTrue(dado.isFormatoValido());
        assertTrue(dado.isSeguro());
        assertEquals(3, dado.getDadosProcessados().size());
        assertEquals("[VALIDADO] item1", dado.getDadosProcessados().get(0));
        assertEquals("BancoDeDados_MySQL", dado.getLocalSalvamento());
    }

    @Test
    void deveProcessarArquivoJSONESalvarNoS3AlterandoEstrategia() {
        etapaPersistencia.setStrategy(new PersistenciaS3Strategy());
        ItemDado dado = new ItemDado("dados.json", "{\"chave1\":\"valor1\"; \"chave2\":\"valor2\"}");
        boolean sucesso = pipeline.executar(dado);
        assertTrue(sucesso);
        assertEquals("[VALIDADO] chave1:valor1", dado.getDadosProcessados().get(0));
        assertEquals("Nuvem_Amazon_S3", dado.getLocalSalvamento());
    }

    @Test
    void deveInterromperPipelineQuandoFormatoForInvalido() {
        ItemDado dado = new ItemDado("documento.pdf", "conteudo do pdf");
        boolean sucesso = pipeline.executar(dado);
        assertFalse(sucesso);
        assertFalse(dado.isFormatoValido());
        assertNull(dado.getLocalSalvamento());
    }

    @Test
    void deveInterromperPipelineQuandoDetectarScriptMalicioso() {
        ItemDado dado = new ItemDado("dados.csv", "item1,SCRIPT_MALICIOSO,item3");
        boolean sucesso = pipeline.executar(dado);
        assertFalse(sucesso);
        assertTrue(dado.isFormatoValido());
        assertFalse(dado.isSeguro());
        assertNull(dado.getLocalSalvamento());
    }
}
