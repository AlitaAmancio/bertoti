public class App {
    public static void main(String[] args) throws Exception {
        //Criando arquivos
        Arquivo arquivo1 = new Arquivo("arquivo1.txt", 200);
        Arquivo arquivo2 = new Arquivo("arquivo2.png", 2500);
        Arquivo arquivo3 = new Arquivo("documento.pdf", 800);

        //Criando pastas
        Pasta pastaDocumentos = new Pasta("Documentos");
        Pasta pastaFotos = new Pasta("Fotos");
        Pasta pastaPrincipal = new Pasta("Pasta Principal");

        //Adicionando arquivos às pastas
        pastaDocumentos.adicionar(arquivo1);
        pastaDocumentos.adicionar(arquivo3);
        pastaFotos.adicionar(arquivo2);

        //Adicionando pastas à pasta principal
        pastaPrincipal.adicionar(pastaDocumentos);
        pastaPrincipal.adicionar(pastaFotos);

        //Exibindo o conteúdo da pasta principal
        System.out.println("Conteúdo da " + pastaPrincipal.getClass().getSimpleName() + ":");
        pastaPrincipal.mostrar();

        //Exibindo o tamanho total da pasta principal
        System.out.println("\nTamanho da pasta principal: " + pastaPrincipal.getTamanho() + " bytes.");
    }
}
