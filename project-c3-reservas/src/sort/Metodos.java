package primeiro;

import java.util.ArrayList;

public class Metodos {
    public Metodos() {}

 // Método auxiliar privado para comparar duas Reservas
    private int comparar(Reserva r1, Reserva r2) {
        int compNome = r1.getNome().compareTo(r2.getNome());

        // Se os nomes NÃO são iguais, retorne a comparação dos nomes
        if (compNome != 0) {
            return compNome;
        }

        // Se os nomes SÃO iguais, desempate pelo código da reserva
        return r1.getCodigo().compareTo(r2.getCodigo());
    }    
    
    public void quick(ArrayList<Reserva> lista, int esq, int dir) {
        // BUG 1 CORRIGIDO: i começa em esq, j começa em dir
        int i = esq, j = dir;

     // BUG 2 CORRIGIDO: O pivô é um objeto Reserva, não só o nome
        Reserva pivo = lista.get((esq + dir) / 2);
        
        
        do {
        	while (comparar(lista.get(i), pivo) < 0) i++;
            while (comparar(lista.get(j), pivo) > 0) j--;

            if (i <= j) {
                Reserva temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
                i++;
                j--;
            }
        } while (i <= j);

        if (esq < j) quick(lista, esq, j);
        if (i < dir) quick(lista, i, dir);
        
     // O método não precisa retornar a lista, pois ela é ordenada
     // (a própria lista original é modificada)

    }


}

