/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobimestral;

/**
 *
 * @author Notebook
 */
public class No {
    private int info;
    private No ant;
    private No prox;

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public No(int info, No ant, No prox) {
        this.info = info;
        this.ant = ant;
        this.prox = prox;
    }

}


