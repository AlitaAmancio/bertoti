public class App {
    public static void main(String[] args) throws Exception {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        
        if (db1.isConnected()) {
            System.out.println("Conexão ativa e pronta para uso!");
        }

        DatabaseConnection db2 = DatabaseConnection.getInstance();

        if (db1 == db2) {
            System.out.println("As instâncias são iguais. Singleton está funcionando!");
        } else {
            System.out.println("Algo deu errado. Instâncias diferentes foram criadas.");
        }

        db1.closeConnection();
        if (!db1.isConnected()) {
            System.out.println("Conexão foi encerrada com sucesso.");
        }
    }
}
