package controller;

import java.io.*;
import java.util.ArrayList;
import model.Reserva;

public class UtilsArquivo {
    public static void lerArquivo(String caminho, ArrayList<Reserva> lista) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");

                String reserva = campos[0];
                String nome = campos[1];
                String voo = campos[2];
                String data = campos[3];
                String assento = campos[4];

                Reserva r = new Reserva(reserva, nome, voo, data, assento);
                lista.add(r);
            }

        } catch (IOException e) {
            System.out.println("Arquivo não lido!");
        }
    }

    public static void salvarArquivo(ArrayList<Reserva> lista) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Felipe\\OneDrive\\Documentos\\Faculdade\\3 Período\\pesquisa-e-ordenacao\\project-c3-reservas\\resultados"))) {
            for (Reserva r : lista) {
                pw.println(r.getCodigo() + ";" +
                        r.getNome() + ";" +
                        r.getVoo() + ";" +
                        r.getData() + ";" +
                        r.getAssento());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}
