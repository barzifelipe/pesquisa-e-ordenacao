package sort;

import java.util.ArrayList;
import model.Reserva;
import utils.Sort;

public class HeapSort {
    public static void ordenarArquivoHeap(ArrayList<Reserva> lista){
        int dir = lista.size()-1;
        int esq = (dir -1)/2;
        Reserva temp;

        while (esq >= 0){
            refazerHeap(lista, esq, lista.size()-1);
            esq--;
        }

        while (dir > 0){
            temp = lista.get(0);
            lista.set(0, lista.get(dir));
            lista.set(dir, temp);
            dir--;
            refazerHeap(lista, 0, dir);
        }

    }

    public static void refazerHeap(ArrayList<Reserva> lista, int esq, int dir){
        int i = esq, mF = 2*i+1;
        Reserva raiz = lista.get(i);
        boolean heap = false;

        while((mF <= dir && !heap)){
            if(mF+1 <= dir) {
                if (Sort.comparar(lista.get(mF), lista.get(mF + 1)) < 0) {
                    mF++;
                }
            }
                if(Sort.comparar(raiz, lista.get(mF))< 0){
                    lista.set(i, lista.get(mF));
                    i = mF;
                    mF = 2*i+1;
                }
                else{
                    heap = true;
                }
            }

        lista.set(i, raiz);

    }
}
