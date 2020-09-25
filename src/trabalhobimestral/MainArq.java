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
public class MainArq {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Arquivo a = new Arquivo("C:\\Arquivos\\trabalhobim.dat");
       Registro reg = new Registro();
       Random gerador = new Random();
        /*for(int i = 0;i < 10;i++)
        {
            reg.setNumero(gerador.nextInt(26));
            a.inserirRegNoFinal(reg);
        }*/
        //a.insercaoDireta();
        a.exibirArq();
        System.out.println(a.getMov() + " Movimentacoes");
        System.out.println(a.getComp() + " Comparacoes");
    }
    
}
