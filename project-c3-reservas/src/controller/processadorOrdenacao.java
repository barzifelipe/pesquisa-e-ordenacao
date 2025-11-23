package controller;

import java.util.ArrayList;

import sort.QuickIns;
import sort.QuickSort;
import utils.Paths;
import utils.Arquivo;
import model.Reserva;
import sort.HeapSort;

public class processadorOrdenacao {
    static final int REPETICOES = 5;

    public static void executarHeap(){
        ArrayList<Reserva> lista = new ArrayList<>();
        System.out.println("||HeapSort||");

        for (String nomeArquivo : Paths.ARQUIVOS) {

            long tempoTotal = 0;

            for (int i = 1; i <= REPETICOES; i++) {

                lista.clear();

                Arquivo.lerArquivo(Paths.BASE_PATH + nomeArquivo, lista);

                long inicio = System.nanoTime();
                HeapSort.ordenarArquivoHeap(lista);
                long fim = System.nanoTime();
                tempoTotal += (fim - inicio);

                Arquivo.salvarArquivo(lista, "heap", "heap_" + nomeArquivo);
            }

            double media = (tempoTotal / REPETICOES) / 1_000_000.0;
            System.out.println("Arquivo: " + nomeArquivo + " | Média: "  + media + " ms");
        }
    }

    public static void executarQuick(){
        ArrayList<Reserva> lista = new ArrayList<>();
        System.out.println("\n||QuickSort||");

        for (String nomeArquivo : Paths.ARQUIVOS) {

            long tempoTotal = 0;

            for (int i = 1; i <= REPETICOES; i++) {

                lista.clear();

                Arquivo.lerArquivo(Paths.BASE_PATH + nomeArquivo, lista);

                long inicio = System.nanoTime();
                QuickSort.ordenarArquivoQuick(lista, 0, lista.size() - 1);
                long fim = System.nanoTime();
                tempoTotal += (fim - inicio);

                Arquivo.salvarArquivo(lista, "quick", "quick_" + nomeArquivo);
            }

            double media = (tempoTotal / REPETICOES) / 1_000_000.0;
            System.out.println("Arquivo: " + nomeArquivo + " | Média: "  + media + " ms");
        }
    }

    public static void executarQuickIns(){
        ArrayList<Reserva> lista = new ArrayList<>();
        System.out.println("\n||QuickIns||");

        for (String nomeArquivo : Paths.ARQUIVOS) {

            long tempoTotal = 0;

            for (int i = 1; i <= REPETICOES; i++) {

                lista.clear();

                Arquivo.lerArquivo(Paths.BASE_PATH + nomeArquivo, lista);

                long inicio = System.nanoTime();
                QuickIns.ordenarArquivoQuickIns(lista, 0, lista.size() - 1);
                long fim = System.nanoTime();
                tempoTotal += (fim - inicio);

                Arquivo.salvarArquivo(lista, "quickIns", "quickIns_" + nomeArquivo);
            }

            double media = (tempoTotal / REPETICOES) / 1_000_000.0;
            System.out.println("Arquivo: " + nomeArquivo + " | Média: "  + media + " ms");
        }
    }
}
