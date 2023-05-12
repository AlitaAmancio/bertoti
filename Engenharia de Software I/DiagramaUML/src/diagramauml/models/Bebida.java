/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diagramauml.models;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fatec
 */
public class Bebida {
    private int id;
    private int preco;
    private int quantidade;
    
    public Bebida(int id, int preco, int quantidade) {
        this.id = id;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getPreco() {
        return preco;
    }
    
    public void setPreco(int preco) {
        this.preco = preco;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }   
    
    public int calcularValor() {
        return preco * quantidade;
    }
    
    public void imprimir() {
        System.out.println("Id: " + id);
        System.out.println("Preco: " + preco);
        System.out.println("Quantidade: " + quantidade);
    }
}
