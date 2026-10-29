package padroescomportamentais.unificado;

import java.util.ArrayList;
import java.util.List;

public abstract class ProcessadorConteudoTemplate {

    public final List<String> processar(String conteudoBruto) {
        String conteudoLimpo = abrirELimpar(conteudoBruto);
        List<String> linhas = extrairRegistros(conteudoLimpo);
        return finalizarProcessamento(linhas);
    }

    private String abrirELimpar(String conteudo) {
        return conteudo.trim();
    }

    protected abstract List<String> extrairRegistros(String conteudo);

    private List<String> finalizarProcessamento(List<String> registros) {
        List<String> resultado = new ArrayList<>();
        for (String reg : registros) {
            resultado.add("[VALIDADO] " + reg);
        }
        return resultado;
    }
}
