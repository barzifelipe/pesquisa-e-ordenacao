package search;

import model.Reserva;
import java.util.ArrayList;

public class NoAVL {
    private String nome;
    private ArrayList<Reserva> reservas;
    private NoAVL esq, dir;
    private int altura;

    public NoAVL(String nome, Reserva r) {
        this.nome = nome;
        this.reservas = new ArrayList<>();
        this.reservas.add(r);
        this.altura = 1;
    }

    public String getNome() { return nome; }
    public ArrayList<Reserva> getReservas() { return reservas; }
    public NoAVL getEsq() { return esq; }
    public NoAVL getDir() { return dir; }
    public void setEsq(NoAVL esq) { this.esq = esq; }
    public void setDir(NoAVL dir) { this.dir = dir; }

    public int getAltura() {
        return altura;
    }

    public void atualizarAltura(NoAVL no) {
        int alturaEsq = 0;
        if (no.getEsq() != null) {
            alturaEsq = no.getEsq().getAltura();
        }

        int alturaDir = 0;
        if (no.getDir() != null) {
            alturaDir = no.getDir().getAltura();
        }

        if (alturaEsq > alturaDir) {
            altura = alturaEsq + 1;
        } else {
            altura = alturaDir + 1;
        }

    }

    public int getFatorBalanceamento(NoAVL no) {
        int alturaEsq;
        if (no.getEsq() == null) {
            alturaEsq = 0;
        } else {
            alturaEsq = no.getEsq().getAltura();
        }

        int alturaDir;
        if (no.getDir() == null) {
            alturaDir = 0;
        } else {
            alturaDir = no.getDir().getAltura();
        }

        return alturaEsq - alturaDir;
    }

}
