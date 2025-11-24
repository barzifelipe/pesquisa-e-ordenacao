package search;

import model.Reserva;
import java.util.ArrayList;

public class AVL {

    private NoAVL raiz = null;

    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.getEsq();
        NoAVL t2 = x.getDir();
        x.setDir(y);
        y.setEsq(t2);
        y.atualizarAltura(y);
        x.atualizarAltura(x);
        return x;
    }

    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.getDir();
        NoAVL t2 = y.getEsq();
        y.setEsq(x);
        x.setDir(t2);
        x.atualizarAltura(x);
        y.atualizarAltura(y);
        return y;
    }

    public void inserir(Reserva r) {
        if (r.getNome() == null || r.getNome().isBlank() || r == null) return;
        raiz = inserirRec(raiz, r.getNome().trim(), r);
    }

    private NoAVL inserirRec(NoAVL no, String nome, Reserva r) {
        if (no == null) return new NoAVL(nome, r);

        int cmp = nome.compareToIgnoreCase(no.getNome());
        if (cmp < 0) no.setEsq(inserirRec(no.getEsq(), nome, r));
        else if (cmp > 0) no.setDir(inserirRec(no.getDir(), nome, r));
        else no.getReservas().add(r);

        no.atualizarAltura(no);
        return balancear(no);
    }

    private NoAVL balancear(NoAVL no) {
        int fb = no.getFatorBalanceamento(no);

        if (fb > 1) {
            if (no.getFatorBalanceamento(no.getEsq()) < 0) no.setEsq(rotacaoEsquerda(no.getEsq()));
            return rotacaoDireita(no);
        }

        if (fb < -1) {
            if (no.getFatorBalanceamento(no.getDir()) > 0) no.setDir(rotacaoDireita(no.getDir()));
            return rotacaoEsquerda(no);
        }

        return no;
    }


    public ArrayList<Reserva> pesquisar(String nomeBuscado) {
        if (nomeBuscado == null || nomeBuscado.isBlank())
            return new ArrayList<>();

        NoAVL no = pesquisarRec(raiz, nomeBuscado.trim());

        if (no != null) {
            return no.getReservas();
        } else {
            return new ArrayList<>();
        }
    }

    private NoAVL pesquisarRec(NoAVL no, String nome) {
        if (no == null){
            return null;
        }

        int comp = nome.compareToIgnoreCase(no.getNome());
        if (comp == 0){
            return no;
        }
        if (comp < 0){
            return pesquisarRec(no.getEsq(), nome);
        }
        else {
            return pesquisarRec(no.getDir(), nome);
        }
    }
}