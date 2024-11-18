public class DatabaseConnection {
    private static DatabaseConnection instance;

    private boolean isConnected;

    private DatabaseConnection() {
        System.out.println("Simulando a conexão com o banco de dados...");
        isConnected = true;
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void closeConnection() {
        System.out.println("Fechando a conexão simulada...");
        isConnected = false;
    }
}
