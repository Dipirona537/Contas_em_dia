
package com.dipirona.contas;
import java.io.IOException;


public class escrita_dados {
    static String data = processamento.data();
    static String file_nome = "Contas";
    static String arquivoed = (file_nome+""+data+".txt");
    public static String nome_arquivo(){
        return arquivoed;
    }

    public static void criararquivo() throws IOException {
        Runtime.getRuntime().exec("cmd /c start cmd.exe /k mkdir Contas"+data);
        Runtime.getRuntime().exec("cmd /c start cmd.exe /k type nul > arquivo.txt");
    }

    public static void mover_arquivo(){
        try {
            Runtime.getRuntime().exec("cmd /c start cmd.exe /k type move arquivo.txt C:\\Contas");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
