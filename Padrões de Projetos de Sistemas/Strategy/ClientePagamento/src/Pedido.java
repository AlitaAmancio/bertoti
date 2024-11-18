public class Pedido {

    private Pagamento pagamento;
    
    public Pedido() {

    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void realizarPagamento(double valor) {
        if (pagamento != null) {
            pagamento.realizarPagamento(valor);
        } else {
            System.out.println("Nenhum sistema de pagamento definido!");
        }
    }

}