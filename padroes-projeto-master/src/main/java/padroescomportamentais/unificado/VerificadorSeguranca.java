package padroescomportamentais.unificado;

public class VerificadorSeguranca extends EtapaPipeline {

    @Override
    protected boolean processarEtapa(ItemDado dado) {
        if (!dado.getConteudoBruto().contains("SCRIPT_MALICIOSO")) {
            dado.setSeguro(true);
            return true;
        }
        dado.setSeguro(false);
        return false;
    }
}