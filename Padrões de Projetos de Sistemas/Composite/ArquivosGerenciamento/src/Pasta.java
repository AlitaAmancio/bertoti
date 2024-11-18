import java.util.ArrayList;
import java.util.List;

public class Pasta implements Componente {
    private String nome;
    private List<Componente> filhos;

    public Pasta(String nome) {
        this.nome = nome;
        this.filhos = new ArrayList<>();
    }

    public void adicionar(Componente componente) {
        filhos.add(componente);
    }

    @Override
    public void mostrar(){
        System.out.println("Pasta: " + nome);
        for(Componente filho:filhos) {
            filho.mostrar();
        }
    }

    @Override
    public Integer getTamanho(){
        Integer tamanhoTotal = 0;
        for(Componente filho:filhos) {
            tamanhoTotal += filho.getTamanho();
        }
        return tamanhoTotal;
    }
}
