package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.Reserva;

public class HashingEncadeado {

    private final List<LinkedList<Reserva>> tabela;
    private final int tamanho;


    public HashingEncadeado(int tamanho) {
        if (tamanho < 3) {
            this.tamanho = 3;
        } else {
            this.tamanho = tamanho;
        }

        tabela = new ArrayList<>(this.tamanho);

        for (int i = 0; i < this.tamanho; i++) {
            tabela.add(new LinkedList<>());
        }
    }

    private int hash(String nome) {
        nome = nome.toLowerCase();
        int hash = 0;
        int p = 31;
        for (int i = 0; i < nome.length(); i++) {
            hash = (hash * p + nome.charAt(i)) % tamanho;
        }
        return hash;
    }

    public void inserir(Reserva r) {
        if (r == null || r.getNome() == null) {
            return;
        }
        tabela.get(hash(r.getNome())).add(r);
    }

    public ArrayList<Reserva> pesquisar(String nome) {
        ArrayList<Reserva> resultado = new ArrayList<>();
        if (nome == null) {
            return resultado;
        }

        int pos = hash(nome);
        for (Reserva r : tabela.get(pos)) {
            if (r.getNome().equalsIgnoreCase(nome)){
                resultado.add(r);
            }
        }
        return resultado;
    }
}

