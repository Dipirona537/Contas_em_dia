package com.dipirona.contas;

import java.io.IOException;

public class principal {
    public static void main(String[] args){
        try {
            escrita_dados.criararquivo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        processamento.contas_valor();
        escrita_dados.mover_arquivo();
        //
    }
}
