package sort;

import java.util.ArrayList;
import model.Reserva;

public class HeapSort {
    public static void ordenarArquivoHeap(ArrayList<Reserva> lista, int esq, int dir){
        dir = lista.size()-1;
        esq = (dir -1)/2;
        Reserva temp;

        while (esq >= 0){
            refazerHeap(lista, esq, lista.size());
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

        while((mF <= dir) && (!heap)){
            if(mF < dir){
                if(lista.get(mF).getNome().compareTo(lista.get(mF+1).getNome()) < 0){
                    mF++;
                }
                if(raiz.getNome().compareTo(lista.get(mF).getNome()) < 0){
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
}
