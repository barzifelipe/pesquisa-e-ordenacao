package controller;

import model.Reserva;
import search.ABB;
import utils.Arquivo;
import utils.Paths;

import java.util.ArrayList;

public class processadorPesquisa {

    static final int REPETICOES = 5;

    public static void pesquisarABB() {

        System.out.println("\n||Árvore ABB||");

        for (String nomeArquivo : Paths.ARQUIVOS) {

            long tempoTotal = 0;

            for (int i = 1; i <= REPETICOES; i++) {
                ArrayList<Reserva> lista = new ArrayList<>();
                lista.clear();
                Arquivo.lerArquivo(Paths.BASE_PATH + nomeArquivo, lista);

                ABB arvore = new ABB();

                long inicio = System.nanoTime();
                for (Reserva r : lista) {
                    arvore.inserir(r);
                }
                arvore.balancear();

                ArrayList<String> nomesPesquisa = new ArrayList<>();
                Arquivo.lerNomes(Paths.BASE_PATH + "nome.txt", nomesPesquisa);

                for(String nome : nomesPesquisa){
                    ArrayList<Reserva> reservasEncontradas = arvore.pesquisar(nome);
                    Arquivo.salvarResultadoPesquisa(nome, lista,"ABB","abb_" + nomeArquivo);
                }

                long fim = System.nanoTime();
                tempoTotal += (fim - inicio);
            }

            double media = (tempoTotal / REPETICOES) / 1_000_000.0;
            System.out.println("Arquivo: " + nomeArquivo + " | Média: " + media + " ms");
        }
    }
}
