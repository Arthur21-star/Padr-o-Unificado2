package padroescomportamentais.unificado;

public class PersistenciaBancoStrategy implements PersistenciaStrategy {
    @Override
    public String salvar(ItemDado dado) {
        return "BancoDeDados_MySQL";
    }
}
