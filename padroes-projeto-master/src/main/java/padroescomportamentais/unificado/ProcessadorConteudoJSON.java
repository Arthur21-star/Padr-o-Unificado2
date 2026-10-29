package padroescomportamentais.unificado;

import java.util.Arrays;
import java.util.List;

public class ProcessadorConteudoJSON extends ProcessadorConteudoTemplate {
    @Override
    protected List<String> extrairRegistros(String conteudo) {
        String limpo = conteudo.replace("{", "").replace("}", "").replace("\"", "");
        return Arrays.asList(limpo.split(";"));
    }
}
