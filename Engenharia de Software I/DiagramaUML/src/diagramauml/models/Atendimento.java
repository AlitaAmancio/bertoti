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
public class Atendimento {

    private int id;
    private int idFuncionario;
    private String nomeFuncionario;
    private List<Mesa> listaMesa;

    public Atendimento(int id, int idFuncionario, String nomeFuncionario) {
        this.id = id;
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        listaMesa = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void adicionarMesa(Mesa mesa) {
        listaMesa.add(mesa);
    }

    public void buscarMesaPorId() {
        String idMesa = "";
        for (Mesa mesa : listaMesa) {
            idMesa = idMesa + " " + mesa.getId();
        }
        Scanner ler = new Scanner(System.in);
        int id;
        System.out.println("Insira o Id da mesa que gostaria de consultar: ");
        System.out.println("Mesas atendidas: " + idMesa);
        id = ler.nextInt();
        for (Mesa mesa : listaMesa) {
            if (mesa.getId() == id) {
                System.out.println("A mesa com o Id inserido e a seguinte: ");
                mesa.imprimir();
            }
        }
    }

    public void calcularGorgeta() {
        double gorgetaMesa = 0;
        double gorgetaTotal;
        for (Mesa mesa : listaMesa) {
            gorgetaMesa = gorgetaMesa + mesa.calcularTotalMesa();
        }
        gorgetaTotal = (gorgetaMesa / 100) * 10;
        System.out.println("Por fim, o valor de gorgeta recebido no total do atendimento e de R$: " + gorgetaTotal);

    }

    public void imprimir() {
        System.out.println("Seguem abaixo os detalhes do atendimento: ");
        System.out.println("------------------------");
        System.out.println("Id: " + id);
        System.out.println("Id do atendente: " + idFuncionario);
        System.out.println("Nome do atendente: " + nomeFuncionario);
        System.out.println("------------------------");
        System.out.println("Mesas atendidas: ");
        for (Mesa mesa : listaMesa) {
            mesa.imprimir();
        }
        calcularGorgeta();
    }
    
}
