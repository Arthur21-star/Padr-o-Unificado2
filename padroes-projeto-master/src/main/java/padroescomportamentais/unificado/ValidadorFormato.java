package padroescomportamentais.unificado;

public class ValidadorFormato extends EtapaPipeline {

    @Override
    protected boolean processarEtapa(ItemDado dado) {
        if (dado.getNomeArquivo().endsWith(".csv") || dado.getNomeArquivo().endsWith(".json")) {
            dado.setFormatoValido(true);
            return true;
        }
        dado.setFormatoValido(false);
        return false;
    }
}
