import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            Pedido pedido = new Pedido();
            Integer tipoDePagamento;
            Integer parcelas;
            Double valor;
            
            System.out.println("Escolha o tipo de pagamento: ");
            System.out.println("1: Crédito.");
            System.out.println("2: Débito.");
            tipoDePagamento = scanner.nextInt();
            
            if (tipoDePagamento == 1) {
                System.out.println("--------------------");
                System.out.println("Opção selecionada: Crédito.");
                System.out.println("Digite o número de parcelas: ");
                parcelas = scanner.nextInt();
            
                pedido.setPagamento(new Credito(parcelas));
            }
            else if (tipoDePagamento == 2) {
                System.out.println("--------------------");
                System.out.println("Opção selecionada: Débito.");
            
                pedido.setPagamento(new Debito());
            }
            else {
                System.out.println("--------------------");
                System.out.println("Método de pagamento inválido.");
                return;
            }
            
            System.out.println("--------------------");
            System.out.println("Digite o valor do pagmento: ");
            valor = scanner.nextDouble();
            
            pedido.realizarPagamento(valor);
            
        } catch (InputMismatchException e) {
            System.out.println("--------------------");
            System.out.println("Entrada inválida! Por favor insira números válidos.");
        } finally {
            scanner.close();
        }
    }
}
