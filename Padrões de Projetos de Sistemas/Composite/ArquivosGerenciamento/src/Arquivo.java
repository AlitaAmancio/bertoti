public class Arquivo implements Componente{
    private String nome;
    private Integer tamanho;

    public Arquivo(String nome, Integer tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    @Override
    public void mostrar() {
        System.out.println("Arquivo: " + nome + " - Tamanho: " + tamanho + " bytes");
    }

    @Override
    public Integer getTamanho() {
        return tamanho;
    }
}
