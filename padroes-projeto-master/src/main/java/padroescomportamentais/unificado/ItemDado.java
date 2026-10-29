package padroescomportamentais.unificado;

import java.util.ArrayList;
import java.util.List;

public class ItemDado {
    private String nomeArquivo;
    private String conteudoBruto;
    private boolean formatoValido;
    private boolean seguro;
    private List<String> dadosProcessados = new ArrayList<>();
    private String localSalvamento;

    public ItemDado(String nomeArquivo, String conteudoBruto) {
        this.nomeArquivo = nomeArquivo;
        this.conteudoBruto = conteudoBruto;
    }

    public String getNomeArquivo() { return nomeArquivo; }
    public String getConteudoBruto() { return conteudoBruto; }

    public boolean isFormatoValido() { return formatoValido; }
    public void setFormatoValido(boolean formatoValido) { this.formatoValido = formatoValido; }

    public boolean isSeguro() { return seguro; }
    public void setSeguro(boolean seguro) { this.seguro = seguro; }

    public List<String> getDadosProcessados() { return dadosProcessados; }
    public void setDadosProcessados(List<String> dadosProcessados) { this.dadosProcessados = dadosProcessados; }

    public String getLocalSalvamento() { return localSalvamento; }
    public void setLocalSalvamento(String localSalvamento) { this.localSalvamento = localSalvamento; }
}
