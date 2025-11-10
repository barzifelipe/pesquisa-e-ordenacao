package sort;

import java.util.ArrayList;
import model.Reserva;

public class QuickIns {
    public static void ordenarArquivoQuickIns(ArrayList<Reserva> lista, int esq, int dir){
        int tamanho = dir - esq +1;

        if(tamanho <= 20){
            ordenarArquivoInsercaoDireta(lista,esq,dir);
        }
        else{
            QuickSort.ordenarArquivoQuick(lista,esq,dir);
        }
    }

    public static void ordenarArquivoInsercaoDireta(ArrayList<Reserva> lista, int esq, int dir){
        Reserva temp;

        for(int i= esq+1; i <= dir; i++){
            temp = lista.get(i);
            int j = i-1;

            while((j>=esq) && (lista.get(j).getNome().compareTo(temp.getNome()) > 0)){
               lista.set(j+1, lista.get(j));
                j--;
            }
            lista.set(j+1, temp);
        }
    }

}
