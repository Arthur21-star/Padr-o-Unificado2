package padroescomportamentais.unificado;

public abstract class EtapaPipeline {

    private EtapaPipeline proximaEtapa;

    public EtapaPipeline setProxima(EtapaPipeline proximaEtapa) {
        this.proximaEtapa = proximaEtapa;
        return proximaEtapa;
    }

    public boolean executar(ItemDado dado) {
        if (!processarEtapa(dado)) {
            return false;
        }
        if (proximaEtapa != null) {
            return proximaEtapa.executar(dado);
        }
        return true;
    }

    protected abstract boolean processarEtapa(ItemDado dado);
}
