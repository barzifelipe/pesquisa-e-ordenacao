package main;

import java.util.ArrayList;
import controller.UtilsArquivo;
import model.Reserva;
import sort.QuickSort;

public class MainQuick {
    public static void main(String[] args) {
        ArrayList<Reserva> lista = new ArrayList<>();
        UtilsArquivo.lerArquivo("caminho/arquivo.txt", lista);
        QuickSort.ordenarArquivoQuick(lista, 0, lista.size() - 1);
        UtilsArquivo.salvarArquivo(lista);
    }
}
