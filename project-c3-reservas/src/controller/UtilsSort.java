package controller;
import model.Reserva;

public class UtilsSort {
    public static int comparar(Reserva a, Reserva b){
        int comparacao = a.getNome().compareToIgnoreCase(b.getNome());
        if (comparacao != 0){
            return comparacao;
        }
        return a.getCodigo().compareToIgnoreCase(b.getCodigo());
    }
}
