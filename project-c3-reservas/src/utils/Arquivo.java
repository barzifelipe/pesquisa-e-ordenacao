package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.Reserva;


public class Arquivo {
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

    public static void salvarArquivo(ArrayList<Reserva> lista, String subpasta, String nomeArquivo) {
        File resultados = new File("project-c3-reservas/resultados/" + subpasta);

        if (!resultados.exists()){
            resultados.mkdirs();
        }
        File arquivo = new File(resultados, nomeArquivo);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Reserva r : lista) {
                String linha = (r.getCodigo() + ";" +
                        r.getNome() + ";" +
                        r.getVoo() + ";" +
                        r.getData() + ";" +
                        r.getAssento());

                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public static ArrayList<String> lerNomes(String caminho){
        ArrayList<String> nomes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                nomes.add(linha.trim());
            }
        }

        catch (IOException e){
            System.out.println("Erro ao ler nomes: " + e.getMessage());
        }

        return nomes;
    }

    public static void salvarResultadoPesquisa(String nome, ArrayList<Reserva> lista, String subpasta, String nomeArquivo) {

        File resultados = new File("project-c3-reservas/resultados/" + subpasta);

        if (!resultados.exists()) {
            resultados.mkdirs();
        }

        File arquivo = new File(resultados, nomeArquivo);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write("NOME " + nome + ":");
            bw.newLine();
            if (lista == null || lista.isEmpty()) {
                bw.write("NÃO TEM RESERVA");
                bw.newLine();
                bw.newLine();
                return;
            }
            for (Reserva r : lista) {
                bw.write("Reserva: " + r.getCodigo() + " Voo: " + r.getVoo() + " Data: " + r.getData() + " Assento: " + r.getAssento());
                bw.newLine();
            }
            bw.write("TOTAL: " + lista.size() + " reservas");
            bw.newLine();
            bw.newLine();
        }
        catch (IOException e) {
             System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}

