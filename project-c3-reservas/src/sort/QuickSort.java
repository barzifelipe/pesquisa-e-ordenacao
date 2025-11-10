package  sort;

import java.util.ArrayList;
import controller.UtilsArquivo;
import model.Reserva;

public class QuickSort {
    public  static void ordenarArquivoQuick(ArrayList<Reserva> lista, int esq, int dir) {
        int i = esq, j = dir;
        String pivo = lista.get((esq + dir) / 2).getNome();

        do {
            while (lista.get(i).getNome().compareTo(pivo) < 0) i++;
            while (lista.get(j).getNome().compareTo(pivo) > 0) j--;

            if (i <= j) {
                Reserva temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
                i++;
                j--;
            }
        } while (i <= j);

        if (esq < j) ordenarArquivoQuick(lista, esq, j);
        if (i < dir) ordenarArquivoQuick(lista, i, dir);
    }
}
