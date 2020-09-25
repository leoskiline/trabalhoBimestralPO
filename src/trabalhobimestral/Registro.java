package trabalhobimestral;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Registro {
    public final int tf=1022;
    private int numero;
    private char lixo[] = new char[tf];

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
     
    public Registro()
    {
        this.numero = -1;
        for(int i = 0;i < tf;i++)
            lixo[i] = 'X';
    }
    
    public Registro(int numero)
    {
        this.numero = numero;
        for(int i =0;i<tf;i++)
            lixo[i]='X';
    }
    
    public void gravaNoArq(RandomAccessFile arquivo)
    {
        try
        {
            arquivo.writeInt(numero);
            for(int i = 0;i < tf;i++)
                arquivo.writeChar(lixo[i]);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void exibirReg()
    {
        System.out.println(numero);
    }
    
    public void leDoArq(RandomAccessFile arquivo)
    {
        try
        {
            numero = arquivo.readInt();
            for(int i= 0;i < tf;i++)
                lixo[i] = arquivo.readChar();
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    static int length()
    {
        //int numero; 4 bytes
        //char lixo[] = new char[tf]; 2044 bytes
        //--------------------------------------
        // 2048 bytes
        return(2048);
    }
}
