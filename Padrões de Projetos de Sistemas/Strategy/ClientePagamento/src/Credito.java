public class Credito implements Pagamento {
    
    public Integer parcelas;

    public Credito(Integer parcelas) {
        this.parcelas = parcelas;
    }
    
    public Integer getParcelas() {
        return parcelas;
    }
    
    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public void realizarPagamento(double valor) {
        double valorComJuros;
        double taxaJuros = 0;

        switch (parcelas) {
            case 1:
                taxaJuros = 0;
                break;
            case 2:
                taxaJuros = 0.05;
                break;
            case 3:
                taxaJuros = 0.1;
                break;
            case 4: 
                taxaJuros = 0.2;
                break;
            default:
                taxaJuros = 2.5;
                break;
        }

        valorComJuros = valor * (1 + taxaJuros);

        System.out.println("--------------------");
        System.out.println("Pagamento realizado no crédito no valor de: " + valorComJuros);
    }
}
