/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diagramauml.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Fatec
 */
public class Mesa {

    private int id;
    private int cliente;
    private List<Bebida> listaBebida;

    public Mesa(int id, int cliente) {
        this.id = id;
        this.cliente = cliente;
        listaBebida = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public void adicionarBebida(Bebida bebida) {
        listaBebida.add(bebida);
    }

    public int calcularTotalMesa() {
        int total = 0;
        for (Bebida bebida : listaBebida) {
            total = total + bebida.calcularValor();
        }
        return total;
    }
    
    public void imprimirTotalMesa() {
        System.out.println("O valor total dessa mesa é de R$: " + calcularTotalMesa());
    }

    public void calcularTotalClienteMesa() {
        System.out.println("Esse valor dividido entre todos os clientes equilave a R$" + calcularTotalMesa() / getCliente() + " reais por pessoa.");
    }

    public void imprimir() {
        System.out.println("Id: " + id);
        System.out.println("Numero de clientes: " + cliente);
        System.out.println("As bebidas pedidas por essa mesa foram as seguintes: ");
        for (Bebida bebida : listaBebida) {
            System.out.println("*");
            bebida.imprimir();
        }

        calcularTotalMesa();
        calcularTotalClienteMesa();
        System.out.println("------------------------");
    }
}
