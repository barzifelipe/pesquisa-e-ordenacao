package search;

import model.Reserva;
import java.util.ArrayList;

public class AVL {

    private NoAVL raiz = null;

    public void inserir(Reserva r){
        if (r == null || r.getNome() == null) {
            return;
        }
        raiz = inserir(r, raiz );
    }

    private NoAVL inserir(Reserva r, NoAVL no) {
        if (no == null) return new NoAVL(r.getNome(), r);

        int comp = r.getNome().compareToIgnoreCase(no.getNome());
        if (comp < 0) {
            no.setEsq(inserir(r, no.getEsq()));
        } else if (comp > 0) {
            no.setDir(inserir(r, no.getDir()));
        } else {
            no.getReservas().add(r);
            return no;
        }

        no.atualizarAltura();

        return balancear(no);
    }


    private NoAVL balancear(NoAVL no) {
        int fb = no.getFatorBalanceamento();

        if (fb > 1) { // esquerda pesada
            if (no.getEsq().getFatorBalanceamento() < 0) {
                no.setEsq(rotacaoEsquerda(no.getEsq())); // rotação dupla
            }
            no = rotacaoDireita(no);
        } else if (fb < -1) { // direita pesada
            if (no.getDir().getFatorBalanceamento() > 0) {
                no.setDir(rotacaoDireita(no.getDir())); // rotação dupla
            }
            no = rotacaoEsquerda(no);
        }

        return no;
    }


    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.getEsq();
        NoAVL T2 = x.getDir();

        x.setDir(y);
        y.setEsq(T2);

        y.atualizarAltura();
        x.atualizarAltura();

        return x;
    }


    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.getDir();
        NoAVL T2 = y.getEsq();

        y.setEsq(x);
        x.setDir(T2);

        x.atualizarAltura();
        y.atualizarAltura();

        return y;
    }

    public ArrayList<Reserva> pesquisar(String nomeBuscado) {

        if (nomeBuscado == null || nomeBuscado.isEmpty())
            return new ArrayList<>();

        NoAVL atual = raiz;

        while (atual != null) {

            int comp = nomeBuscado.compareToIgnoreCase(atual.getNome());

            if (comp == 0) {
                return atual.getReservas();
            }
            else if (comp < 0) {
                atual = atual.getEsq();
            }
            else {
                atual = atual.getDir();
            }
        }

        return new ArrayList<>();
    }
}
