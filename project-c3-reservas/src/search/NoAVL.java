package search;

import java.util.ArrayList;
import model.Reserva;

public class NoAVL {

    private String nome;
    private ArrayList<Reserva> reservas;
    private NoAVL esq;
    private NoAVL dir;
    private int altura;

    public NoAVL(String nome) {
        this.nome = nome;
        this.reservas = new ArrayList<>();
        this.altura = 1;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public NoAVL getEsq() {
        return esq;
    }

    public void setEsq(NoAVL esq) {
        this.esq = esq;
    }

    public NoAVL getDir() {
        return dir;
    }

    public void setDir(NoAVL dir) {
        this.dir = dir;
    }

    public int getAltura(){
        return altura;
    }
}
