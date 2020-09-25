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
public class ListaEncadeada {
    private No inicio;
    private No fim;

    public ListaEncadeada(No inicio, No fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public ListaEncadeada() {
        this.inicio = this.fim = null;
    }
    
    public void inicializa()
    {
        this.inicio = this.fim = null;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }
    
    public void inserir(int info)
    {   
        No nova = new No(info,null,null);
        if(inicio == null)
        {
            inicio = nova;
            fim = nova;
        }
        else
        {
            No aux = inicio;
            while(aux.getProx()!= null)
                aux = aux.getProx();
            nova.setAnt(aux);
            aux.setProx(nova);
            fim = nova;
        }
    }
    
    public No busca(int info)
    {
        No percorre = inicio;
        while(percorre != null)
        {
            if(percorre.getInfo() == info)
                return percorre;
            percorre = percorre.getProx();
        } 
        return null;
    }
    
    public void remove(int info)
    {
        No ant = null;
        No percorre = inicio;
        while(percorre != null && percorre.getInfo() != info)
        {
            ant = percorre;
            percorre = percorre.getProx();
        }
        if(ant == null)
            inicio = percorre.getProx();
        else
            ant.setProx(percorre.getProx());
        if(percorre == null)
           System.out.println("Nao foi possivel remover, elemento nao encontrado.");
    }
    
    
    public boolean isEmpty()
    {
        if(inicio == null)
            return true;
        else
            return false;
    }
    
    public void exibir()
    {
        No aux = inicio;
        while(aux != null)
        {
            System.out.println(aux.getInfo());
            aux = aux.getProx();
        }
    }
    
    //Metodos de Ordenacao
    public void insercaoDireta()
    {
        No i,pos;
        int aux;
        i = inicio.getProx();
        while(i != null)
        {
            pos = i;
            aux = i.getInfo();
            while(pos != inicio && aux < pos.getAnt().getInfo())
            {
                pos.setInfo(pos.getAnt().getInfo());
                pos = pos.getAnt();
            }
            pos.setInfo(aux);
            i = i.getProx();
        }
    }
    
    public  void insercaoBinaria()
    {
        No i,j,pos;
        i = inicio.getProx();
        while(i != null)
        {
            pos = buscaBinaria(i.getInfo(),i.getAnt());
            j = i;
            while(pos != j)
            {
                swap(j,j.getAnt());
                j = buscaNo(j,-1);
            }
            swap(pos,j);
            i = buscaNo(i,1);
        }
    }
    public void BubbleSort()
    {
        No i,j;
        j = buscaNo(inicio,0);
        while(j != inicio.getProx())
        {
            i = inicio;
            while(i != j)
            {
                if(i.getInfo()> i.getProx().getInfo())
                    swap(i,i.getProx());
                i = i.getProx();
            }
            j = j.getAnt();
        }
    }
    
    public void shake()
    {
        No i,j,aux;
        j = buscaNo(inicio,0);
        i = inicio;
        while(j != i )
        {
            aux = i;
            while(aux != j)
            {
                if(aux.getInfo() > aux.getProx().getInfo())
                    swap(aux,aux.getProx());
                aux = aux.getProx();
            }
            aux = aux.getAnt();
            while(aux != i)
            {
                if(aux.getInfo() < aux.getAnt().getInfo())
                    swap(aux,aux.getAnt());
                aux = aux.getAnt();
            }
            i = i.getProx();
            if(i != j)
                j = j.getAnt();
        }
    }
    
    public void heap()
    {
        int n,tl = 0;
        No pai,fd,fe,fmaior,fim = inicio;
        while(fim.getProx()!= null)
        {
            fim = fim.getProx();
            tl++;
        }
        tl++;
        while(fim != inicio)
        {
            for(n = tl /2 - 1;n >=0;n--)
            {
                if(n == 0)
                    pai = inicio;
                else
                    pai = buscaNo(inicio,n);
                fe = buscaNo(inicio,n+n+1);
                fd = buscaNo(fe,1);
                fmaior=fe;
                if(n+n+2<tl && fd.getInfo() > fe.getInfo())
                    fmaior = fd;
                
                if(fmaior.getInfo() > pai.getInfo())
                    swap(pai,fmaior);  
            }
            swap(inicio,fim);
            tl--;
            fim = fim.getAnt();
        }      
    }
    
    public void geraRandomica()
    {
        Random r = new Random();
        for(int i = 0; i < 10;i++)
        {
            inserir(r.nextInt(100));
        }
    }
    
    public void geraOrdenada()
    {
        for(int i = 10;i <= 100; i = i + 10)
        {
            inserir(i);
        }
    }
    
    public ListaEncadeada copiaLista(ListaEncadeada lista)
    {
        No aux = lista.getInicio();
        ListaEncadeada nova = new ListaEncadeada();
        while(aux != null)
        {
            nova.inserir(aux.getInfo());
            aux = aux.getProx();
        }
        return nova;
    }
    
    public void geraReversa()
    {
        for(int i = 100;i >= 10;i = i - 10)
        {
            inserir(i);
        }
    }
    
    public void shell()
    {
        int distancia;
        No i, distAux, j, distJ, k, distK;
        
        for(distancia = 4; distancia > 0; distancia /= 2)
        {
            distAux = buscaNo(inicio, distancia);
            i = inicio;
            while(i != distAux)
            {
                j = i;
                distJ = buscaNo(j, distancia);
                while(distJ != null)
                {
                    if(j.getInfo() > distJ.getInfo())
                    {
                        swap(j, distJ);
                        
                        k = j;
                        distK = buscaNo(k, -distancia);
                        
                        while(distK != null)
                        {
                            if(k.getInfo() < distK.getInfo())
                                swap(k, distK);
                            
                            k = distK;
                            distK = buscaNo(k, -distancia);
                        }
                    }
                    
                    j = distJ;
                    distJ = buscaNo(j, distancia);
                }
                
                i = i.getProx();
            }
        }
    }
    
    private No buscaBinaria(int info,No tl)
    {
        No ini = inicio,meio,fim=tl;
        int pos = tamanhoLista(inicio,fim) / 2;
        boolean flag;
        if(pos == 0)
            meio = ini;
        else
            meio = buscaNo(ini,pos);
        while(ini != meio && meio.getInfo() != info)
        {
            if(info < meio.getInfo())
            {
                fim = meio;
                flag = true;
            }
            else
            {
                flag = false;
                ini = meio;
            }
            pos = tamanhoLista(ini,fim)/2;
            
            if(pos == 0)
                meio = ini;
            else
                if(flag)
                {
                    pos *= -1;
                    meio = buscaNo(fim,pos);
                }
            else
                    meio = buscaNo(ini,pos);
        }
        if(info > tl.getInfo())
            return tl;
        if(info > meio.getInfo())
            return meio.getProx();
        return meio;
    }
    
    private No buscaNo(No no,int qtd)
    {
        if(qtd == 0)
            while(no.getProx() != null)
                no = no.getProx();
        else
        {
            while(qtd != 0 && no != null)
            {
                if(qtd > 0)
                {
                    no = no.getProx();
                    qtd--;
                }
                else
                {
                    no = no.getAnt();
                    qtd++;
                }
            }
        }
        return no;
    }
    
    private int tamanhoLista(No lista1,No lista2)
    {
        int i = 1;
        if(lista1 == lista2)
            return 0;
        
        while(lista1.getProx() != lista2)
        {
            lista1 = lista1.getProx();
            i++;
        }
        return i;
    }
    
    private void swap(No no1,No no2)
    {
        No aux = new No(no1.getInfo(),null,null);
        no1.setInfo(no2.getInfo());
        no2.setInfo(aux.getInfo());
    }
}
