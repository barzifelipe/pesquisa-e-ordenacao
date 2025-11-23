package  sort;

import java.util.ArrayList;
import utils.Sort;
import model.Reserva;

public class QuickSort {
    public  static void ordenarArquivoQuick(ArrayList<Reserva> lista, int esq, int dir) {
        int i = esq, j = dir;
        Reserva pivo = lista.get((esq + dir) / 2);

        do {
            while (Sort.comparar(lista.get(i), pivo) < 0){
                i++;
            }
            while (Sort.comparar(lista.get(j), pivo) > 0){
                j--;
            }

            if (i <= j) {
                Reserva temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
                i++;
                j--;
            }
        } while (i <= j);

        if (esq < j){
            ordenarArquivoQuick(lista, esq, j);
        }
        if (i < dir){
            ordenarArquivoQuick(lista, i, dir);
        }
    }
}
