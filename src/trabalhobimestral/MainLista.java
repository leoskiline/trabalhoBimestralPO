/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobimestral;

import java.util.Random;

/**
 *
 * @author Notebook
 */
public class MainLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        ListaEncadeada lista2 = new ListaEncadeada();
        //lista.geraRandomica();
        //lista.geraOrdenada();
        lista.geraReversa();
        //lista.insercaoDireta();
        //lista.insercaoBinaria();
        //lista.BubbleSort();
        //lista.shake();
        //lista.heap();
        //lista.shell();
        //lista2 = lista2.copiaLista(lista);
        lista.exibir();
    }
    
}
