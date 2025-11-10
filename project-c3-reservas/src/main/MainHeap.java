package main;

import java.util.ArrayList;
import controller.UtilsArquivo;
import model.Reserva;
import sort.HeapSort;

public class MainHeap {
    public static void main(String[] args) {
        ArrayList<Reserva> lista = new ArrayList<>();
        UtilsArquivo.lerArquivo("caminho", lista);
        HeapSort.ordenarArquivoHeap(lista, 0, lista.size() - 1);
        UtilsArquivo.salvarArquivo(lista, "caminho para salvar");
    }
}
