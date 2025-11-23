package main;

import controller.processadorOrdenacao;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO ORDENAÇÕES ===");
        processadorOrdenacao.executarHeap();
        processadorOrdenacao.executarQuick();
        processadorOrdenacao.executarQuickIns();
    }
}
