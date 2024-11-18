public class Debito implements Pagamento {
    
    public void realizarPagamento(double valor) {
        System.out.println("--------------------");
        System.out.println("Pagamento da compra realizado no débito no valor de: " + valor );
    }
}
