package padroescomportamentais.unificado;

public class PersistidorDados extends EtapaPipeline {

    private PersistenciaStrategy strategy;

    public PersistidorDados(PersistenciaStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PersistenciaStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    protected boolean processarEtapa(ItemDado dado) {
        String local = strategy.salvar(dado);
        dado.setLocalSalvamento(local);
        return true;
    }
}
