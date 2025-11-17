package main;

import java.util.ArrayList;

import controller.Paths;
import controller.UtilsArquivo;
import model.Reserva;
import sort.HeapSort;

public class MainHeap {
    public static void main(String[] args) {
        ArrayList<Reserva> lista = new ArrayList<>();

        for(String nome : Paths.NOME_ARQUIVOS) {
            UtilsArquivo.lerArquivo(Paths.BASE_PATH + nome, lista);
            HeapSort.ordenarArquivoHeap(lista, 0, lista.size() - 1);
            UtilsArquivo.salvarArquivo(lista);
        }
    }

}
