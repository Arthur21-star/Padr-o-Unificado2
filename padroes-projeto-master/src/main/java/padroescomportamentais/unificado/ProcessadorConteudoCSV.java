package padroescomportamentais.unificado;

import java.util.Arrays;
import java.util.List;

public class ProcessadorConteudoCSV extends ProcessadorConteudoTemplate {
    @Override
    protected List<String> extrairRegistros(String conteudo) {
        return Arrays.asList(conteudo.split(","));
    }
}
