package controller;

import model.Reserva;
import search.ABB;
import search.AVL;
import search.HashingEncadeado;
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
                //lista.clear();
                Arquivo.lerArquivo(Paths.BASE_PATH + nomeArquivo, lista);

                ABB arvore = new ABB();

                long inicio = System.nanoTime();

                for (Reserva r : lista) {
                    arvore.inserir(r);
                }

                arvore.balancear();

                ArrayList<String> listaDeNomes = Arquivo.lerNomes(Paths.BASE_PATH + "nome.txt");

                for(String nome : listaDeNomes){
                    arvore.pesquisar(nome);
                }

                for(String nome : listaDeNomes){
                    ArrayList<Reserva> resultados = arvore.pesquisar(nome);
                    Arquivo.salvarResultadoPesquisa(nome, resultados,"ABB","abb_" + nomeArquivo);
                }

                long fim = System.nanoTime();
                tempoTotal += (fim - inicio);
            }

            double media = (tempoTotal / REPETICOES) / 1_000_000.0;
            System.out.println("Arquivo: " + nomeArquivo + " | Média: " + media + " ms");
        }
    }

    public static void pesquisarAVL() {

        System.out.println("\n||Árvore AVL||");

        for (String nomeArquivo : Paths.ARQUIVOS) {

            long tempoTotal = 0;

            for (int i = 1; i <= REPETICOES; i++) {

                ArrayList<Reserva> lista = new ArrayList<>();
                //lista.clear();
                Arquivo.lerArquivo(Paths.BASE_PATH + nomeArquivo, lista);

                AVL arvore = new AVL();

                long inicio = System.nanoTime();

                for (Reserva r : lista) {
                    arvore.inserir(r);
                }

                ArrayList<String> listaDeNomes = Arquivo.lerNomes(Paths.BASE_PATH + "nome.txt");

                for(String nome : listaDeNomes){
                    arvore.pesquisar(nome);
                }

                for(String nome : listaDeNomes){
                    ArrayList<Reserva> resultados = arvore.pesquisar(nome);
                    Arquivo.salvarResultadoPesquisa(nome, resultados,"AVL","avl_" + nomeArquivo);
                }

                long fim = System.nanoTime();
                tempoTotal += (fim - inicio);
            }

            double media = (tempoTotal / REPETICOES) / 1_000_000.0;
            System.out.println("Arquivo: " + nomeArquivo + " | Média: " + media + " ms");
        }
    }

    public static void pesquisarHashing() {

        System.out.println("\n||Hashing Ecandeado||");

        for (String nomeArquivo : Paths.ARQUIVOS) {

            long tempoTotal = 0;

            for (int i = 1; i <= REPETICOES; i++) {

                ArrayList<Reserva> lista = new ArrayList<>();
                //lista.clear();
                Arquivo.lerArquivo(Paths.BASE_PATH + nomeArquivo, lista);
                int tamanhoTabela = Math.max(101, lista.size() * 2 + 1);

                HashingEncadeado hash = new HashingEncadeado(tamanhoTabela);

                long inicio = System.nanoTime();

                for (Reserva r : lista) {
                    hash.inserir(r);
                }

                ArrayList<String> listaDeNomes = Arquivo.lerNomes(Paths.BASE_PATH + "nome.txt");

                for(String nome : listaDeNomes){
                    hash.pesquisar(nome);
                }

                for(String nome : listaDeNomes){
                    ArrayList<Reserva> resultados = hash.pesquisar(nome);
                    Arquivo.salvarResultadoPesquisa(nome, resultados,"Hashing","hashing_" + nomeArquivo);
                }

                long fim = System.nanoTime();
                tempoTotal += (fim - inicio);
            }

            double media = (tempoTotal / REPETICOES) / 1_000_000.0;
            System.out.println("Arquivo: " + nomeArquivo + " | Média: " + media + " ms");
        }
    }
}
