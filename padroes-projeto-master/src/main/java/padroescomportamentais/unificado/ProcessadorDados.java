package padroescomportamentais.unificado;

public class ProcessadorDados extends EtapaPipeline {

    @Override
    protected boolean processarEtapa(ItemDado dado) {
        ProcessadorConteudoTemplate template;

        if (dado.getNomeArquivo().endsWith(".csv")) {
            template = new ProcessadorConteudoCSV();
        } else if (dado.getNomeArquivo().endsWith(".json")) {
            template = new ProcessadorConteudoJSON();
        } else {
            return false;
        }

        dado.setDadosProcessados(template.processar(dado.getConteudoBruto()));
        return true;
    }
}
