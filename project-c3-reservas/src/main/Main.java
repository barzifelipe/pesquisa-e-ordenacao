package main;

import controller.processadorOrdenacao;
import controller.processadorPesquisa;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO ORDENAÇÕES ===");
        processadorOrdenacao.executarHeap();
        processadorOrdenacao.executarQuick();
        processadorOrdenacao.executarQuickIns();
        processadorPesquisa.pesquisarABB();
    }
}
