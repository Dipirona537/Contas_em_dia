
package com.dipirona.contas;
import java.io.IOException;


public class escrita_dados {
    public static void criararquivo() throws IOException {
        Runtime.getRuntime().exec("cmd /c start cmd.exe /c type nul > doc_temp.temp");
    }

    public static void mover_arquivo(){
        try {
            try {
                Runtime.getRuntime().exec("renomear.exe");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}//
