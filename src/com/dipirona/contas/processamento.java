package com.dipirona.contas;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class processamento {
    static String nome_arquivo = escrita_dados.nome_arquivo();
    public static String data(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("-dd_MM_yyyy_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String data_completa(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static float contas_valor(){
        /*try {
            FileWriter escrever = new FileWriter(nome_arquivo);
            escrever.write("----------");
            escrever.write(conta_nome);
            escrever.write("R$"+conta_f[i]);
            escrever.write("----------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/ //Escrever as contas no arquivo

        Scanner sc = new Scanner(System.in);

        float valor = 0, subvalor;
        String conta_str;
        float[] conta_f = new float[1024];
        for (int i_f = 0;i_f<1024;i_f++){
            conta_f[i_f] = 0;
        }
        int i = 0;
        while (true){
            System.out.println("Digite o valor da conta, digite 'sair' para sair");
            conta_str = sc.nextLine();
            if (conta_str.equals("sair")){
                System.out.println("Saindo do programa...");
                break;
            }else {
                if (conta_str.matches("[a-zA-Z]+"))
                {
                    System.out.println("Caractere invalido inserido!");
                }else{
                    conta_f[i] = Float.parseFloat(conta_str);
                    subvalor = conta_f[i];
                    valor = subvalor + valor;
                    System.out.println(valor);
                    i++;
                }
            }
        }
        String data = processamento.data_completa();
        System.out.format("O total de suas contas são de R$%.2f\nE você pagou %d contas na data de %s", valor, i, data);
        return valor;
    }
}
