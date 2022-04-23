
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
        Runtime.getRuntime().exec("cmd /c start cmd.exe /c type nul > doc_temp.temp");
    }

    public static void mover_arquivo(){
        try {
            try {
                Runtime.getRuntime().exec("cmd /c start cmd.exe /k type renomear.exe");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
