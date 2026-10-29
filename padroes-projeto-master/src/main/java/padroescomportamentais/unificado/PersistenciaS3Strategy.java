package padroescomportamentais.unificado;

public class PersistenciaS3Strategy implements PersistenciaStrategy {
    @Override
    public String salvar(ItemDado dado) {
        return "Nuvem_Amazon_S3";
    }
}
