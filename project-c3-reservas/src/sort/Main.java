import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String caminho = "C:\\Users\\Felipe\\OneDrive\\Documentos\\Faculdade\\3 Período\\Pesquisa e Ordenação\\Arquivos de Teste\\Reserva500alea.txt";
        ArrayList<Reserva> lista = new ArrayList<>();

        lerArquivo(caminho, lista);
        ordenarArquivoQuick(lista, 0, lista.size() - 1);
        salvarArquivo(lista, "C:\\Users\\Felipe\\OneDrive\\Documentos\\Faculdade\\3 Período\\Pesquisa e Ordenação\\Quick500alea.txt");
        imprimirLista(lista);
    }

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

    private static void ordenarArquivoQuick(ArrayList<Reserva> lista, int esq, int dir) {
        int i = esq, j = dir;
        String pivo = lista.get((esq + dir) / 2).getNome();

        do {
            while (lista.get(i).getNome().compareTo(pivo) < 0) i++;
            while (lista.get(j).getNome().compareTo(pivo) > 0) j--;

            if (i <= j) {
                Reserva temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
                i++;
                j--;
            }
        } while (i <= j);

        if (esq < j) ordenarArquivoQuick(lista, esq, j);
        if (i < dir) ordenarArquivoQuick(lista, i, dir);
    }

    public static void salvarArquivo(ArrayList<Reserva> lista, String caminho) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(caminho))) {
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

    public static void imprimirLista(ArrayList<Reserva> lista){
        for (Reserva r : lista) {
            System.out.println(r);
        }
    }
}



