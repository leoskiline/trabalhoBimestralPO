package trabalhobimestral;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Arquivo {
    private String nomearquivo;
    private RandomAccessFile arquivo;
    private int comp,mov;
    
    public void initComp()
    {
        this.comp = 0;
    }
    
    public void initMov()
    {
        this.mov = 0;
    }
    
    public int getComp() {
        return comp;
    }

    public int getMov() {
        return mov;
    }
    
    public void inserirRegNoFinal(Registro reg)
    {
        seekArq(filesize());
        reg.gravaNoArq(arquivo);
    }
    
    public void exibirArq()
    {
        int i;
        Registro aux = new Registro();
        seekArq(0);
        i = 0;
        while(!this.eof())
        {
            aux.leDoArq(arquivo);
            aux.exibirReg();
            i++;
        }
    }
    
    
    //Ordenacao
    public void insercaoDireta()
    {
        int pos,tl = filesize();
        Registro regaux = new Registro();
        Registro reg = new Registro();
        for(int i = 1;i < tl;i++)
        {
            comp++;
            seekArq(i);
            regaux.leDoArq(arquivo);
            seekArq(i);
		regaux.leDoArq(arquivo);
		pos = i;
		seekArq(pos-1);
		reg.leDoArq(arquivo);
		while(pos > 0 && regaux.getNumero()< reg.getNumero())
		{
                    comp++;
                    comp++;
                    comp++;
			seekArq(pos);
			reg.gravaNoArq(arquivo);
			pos--;
			if(pos > 0)
			{
				seekArq(pos-1);
				reg.leDoArq(arquivo);
			}
		}
		seekArq(pos);
		regaux.gravaNoArq(arquivo);
                mov++;
        }
    }
    
    public void zerarmovcomp()
    {
        this.mov = 0;
        this.comp = 0;
    }
    
    public void exibirUmRegistro(int pos)
    {
        Registro aux = new Registro();
        seekArq(pos);
        System.out.println("Posicao " + pos + ":");
        aux.leDoArq(arquivo);
        aux.exibirReg();
    }
    
    public Arquivo(String nomearquivo)
    {
        try
        {
            arquivo = new RandomAccessFile(nomearquivo,"rw");
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void copiaArquivo(RandomAccessFile arquivoOrigem)
    {
        
    }
    
    public int filesize()
    {
        try
        {
            return (int)(arquivo.length()/Registro.length());
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public void truncate(long pos)
    {
        try
        {
            arquivo.setLength(pos * Registro.length());
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    public boolean eof()
    {
        boolean retorno = false;
        try
        {
            if(arquivo.getFilePointer() == arquivo.length())
                retorno = true;
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        return (retorno);
    }
    public void seekArq(int pos)
    {
        try
        {
            arquivo.seek(pos * Registro.length());
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
