package model;

public class Reserva {

    private final String codigo;
    private final String nome;
    private final String voo;
    private final String data;
    private final String assento;

    public Reserva(String reserva, String nome, String voo, String data, String assento) {
        this.codigo = reserva;
        this.nome = nome;
        this.voo = voo;
        this.data = data;
        this.assento = assento;
    }

    @Override
    public String toString() {
        return codigo + ";" + nome + ";" + voo + ";" + data + ";" + assento;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getVoo() {
        return voo;
    }

    public String getData() {
        return data;
    }

    public String getAssento() {
        return assento;
    }
}
