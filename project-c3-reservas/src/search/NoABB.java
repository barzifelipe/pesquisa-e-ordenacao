package search;

import java.util.ArrayList;
import model.Reserva;

public class NoABB {

    private String nome;
    private ArrayList<Reserva> reservas;
    private NoABB esq;
    private NoABB dir;

    public NoABB(String nome) {
        this.nome = nome;
        this.reservas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public NoABB getEsq() {
        return esq;
    }

    public void setEsq(NoABB esq) {
        this.esq = esq;
    }

    public NoABB getDir() {
        return dir;
    }

    public void setDir(NoABB dir) {
        this.dir = dir;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
}