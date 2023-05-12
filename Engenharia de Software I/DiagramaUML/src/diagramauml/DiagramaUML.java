/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package diagramauml;

import diagramauml.models.Bebida;
import diagramauml.models.Mesa;
import diagramauml.models.Atendimento;
import java.util.Scanner;

/**
 *
 * @author Fatec
 */
public class DiagramaUML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Bebida bebida1, bebida2, bebida3, bebida4, bebida5;
        bebida1 = new Bebida(1, 10, 2);
        bebida2 = new Bebida(2, 15, 1);
        bebida3 = new Bebida(3, 20, 1);
        bebida4 = new Bebida(4, 7, 4);
        bebida5 = new Bebida(5, 12, 3);

        Mesa mesa1, mesa2, mesa3, mesa4;
        mesa1 = new Mesa(1, 3);
        mesa2 = new Mesa(2, 2);
        mesa3 = new Mesa(3, 1);
        mesa4 = new Mesa(4, 5);

        mesa1.adicionarBebida(bebida5);
        mesa1.adicionarBebida(bebida1);
        mesa2.adicionarBebida(bebida4);
        mesa2.adicionarBebida(bebida2);
        mesa4.adicionarBebida(bebida3);

        Atendimento atendimento1;
        atendimento1 = new Atendimento(1, 12, "Sonia");

        atendimento1.adicionarMesa(mesa4);
        atendimento1.adicionarMesa(mesa1);

        Scanner ler = new Scanner(System.in);
        int escolha;
        System.out.println("Digite o numero correspondente a uma das opcoes abaixo: ");
        System.out.println("1 - Consultar um atendimento.");
        System.out.println("2 - Consultar uma mesa especifica desse atendimento por Id.");
        escolha = ler.nextInt();
        switch (escolha) {
            case 1:
                atendimento1.imprimir();
                break;
            case 2:
                atendimento1.buscarMesaPorId();
                break;
            default:
                break;
        }

    }

}
