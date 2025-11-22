package main;

import java.util.ArrayList;

import controller.Paths;
import controller.UtilsArquivo;
import model.Reserva;
import sort.QuickSort;

public class MainQuick {
    public static void main(String[] args) {
        ArrayList<Reserva> lista = new ArrayList<>();

        for (String nomeArquivo : Paths.NOME_ARQUIVOS) {
            UtilsArquivo.lerArquivo(Paths.BASE_PATH + "/" + nomeArquivo, lista);
            QuickSort.ordenarArquivoQuick(lista, 0, lista.size() - 1);
            UtilsArquivo.salvarArquivo(lista, "quick", "quick_" + nomeArquivo);
        }
    }
}
