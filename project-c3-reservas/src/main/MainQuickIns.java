package main;

import java.util.ArrayList;
import controller.UtilsArquivo;
import model.Reserva;
import sort.QuickIns;

public class MainQuickIns {
    public static void main(String[] args) {
        ArrayList<Reserva> lista = new ArrayList<>();
        UtilsArquivo.lerArquivo("caminho/arquivo.txt", lista);
        QuickIns.ordenarArquivoQuickIns(lista, 0, lista.size() - 1);
        UtilsArquivo.salvarArquivo(lista, "caminho para salvar");
    }
}
