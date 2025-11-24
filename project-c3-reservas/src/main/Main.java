package main;

import controller.processadorOrdenacao;
import controller.processadorPesquisa;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO ORDENAÇÕES ===\n");
        //processadorOrdenacao.executarHeap();
//processadorOrdenacao.executarQuick();
        //processadorOrdenacao.executarQuickIns();
        System.out.println("=== INICIANDO PESQUISAS ===\n");
       // processadorPesquisa.pesquisarABB();
        processadorPesquisa.pesquisarAVL();
        //processadorPesquisa.pesquisarHashing();
    }
}
