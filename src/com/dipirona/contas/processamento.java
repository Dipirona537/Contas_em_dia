package com.dipirona.contas;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class processamento {
    static float[] conta_f = new float[1024];
    static int i = 0;
    static float valor = 0, subvalor;
    static String data_completa = data_completa();
    static String nome_conta;

    public static String data_completa(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    static void escrever_nome()
        throws  IOException {
        String dados = "\n"+nome_conta+"\n";
        FileOutputStream outputStream = new FileOutputStream("doc_temp.temp",true);
        byte[] dados_b = (dados.getBytes());
        outputStream.write(dados_b);
    }

    static void escrever()
        throws IOException {
        String dados = String.valueOf(conta_f[i]);
        dados = "Valor R$"+dados+"\n\n";
        FileOutputStream outputStream = new FileOutputStream("doc_temp.temp",true);
        byte[] dados_b = (dados.getBytes());
        outputStream.write(dados_b);
    }

    static void escrever_final()
            throws IOException {
        String dados = String.valueOf(valor);
        dados = "Valor total R$"+(dados)+"\n";
        String conta = String.valueOf(i);
        conta = "Você pagou "+conta+" Contas.\n";
        String data_pg = String.valueOf(data_completa);
        data_pg = "Contas pagas no dia "+data_pg+"\n";
        FileOutputStream outputStream = new FileOutputStream("doc_temp.temp",true);
        byte[] dados_b = (dados.getBytes());
        byte[] conta_b = (conta.getBytes());
        byte[] data_pg_b = (data_pg.getBytes());
        outputStream.write(dados_b);
        outputStream.write(conta_b);
        outputStream.write(data_pg_b);
    }

    public static void contas_valor(){

        Scanner sc = new Scanner(System.in);

        String conta_str;
        for (int i_f = 0;i_f<1024;i_f++){
            conta_f[i_f] = 0;
        }
        while (true){
            System.out.println("Digite o nome da conta, digite `sair` para sair.");
            nome_conta = sc.nextLine();
            if (nome_conta.equals("sair")) {
                System.out.println("Saindo do programa...");
                try {
                    escrever_final();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            System.out.println("Digite o valor da conta, digite 'sair' para sair.");
            conta_str = sc.nextLine();
            if (conta_str.equals("sair")){
                System.out.println("Saindo do programa...");
                try {
                    escrever_final();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }else {
                while (conta_str.matches("[a-zA-Z]+"))
                {
                    System.out.println("Caractere invalido inserido!, digite apenas números!");
                    conta_str = sc.nextLine();
                }
                    conta_f[i] = Float.parseFloat(conta_str);
                    subvalor = conta_f[i];
                    try {
                        escrever_nome();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        escrever();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                valor = subvalor + valor;
                System.out.println("Subtotal = R$"+valor);
                i++;
            }
        }
        String data = processamento.data_completa();
        System.out.format("O total de suas contas são de R$"+valor+"\nE você pagou %d contas na data de %s\n",i, data);
    }
}//
