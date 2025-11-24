package search;

import model.Reserva;

import java.util.ArrayList;

public class ABB {

    private NoABB raiz;

    public void inserir(Reserva r){
        String nome =r.getNome();

        if (raiz == null){
            raiz = new NoABB(nome);
            raiz.getReservas().add(r);
            return;
        }

        NoABB atual = raiz;

        while (true) {
            int comp = nome.compareToIgnoreCase(atual.getNome());

            if (comp < 0){ // vai para a esquerda
                if (atual.getEsq() == null){
                    atual.setEsq(new NoABB(nome));
                    atual.getEsq().getReservas().add(r);
                    break;
                }
                atual = atual.getEsq();
            }
            else if (comp > 0){ // vai para a direita
                if (atual.getDir() == null){
                    atual.setDir(new NoABB(nome));
                    atual.getDir().getReservas().add(r);
                    break;
                }
                atual = atual.getDir();
            }

            else { // nome igual = adiciona reserva na lista do nó existente
                atual.getReservas().add(r);
                break;
            }

        }
    }

    private void camCentral(NoABB no, ArrayList<NoABB> lista){
        if (no == null){
            return;
        }
        camCentral(no.getEsq(), lista);
        lista.add(no);
        camCentral(no.getDir(), lista);
    }

    private NoABB construirBalanceada(ArrayList<NoABB> lista, int inicio, int fim){
        if (inicio > fim) return null;

        int meio = (inicio + fim) / 2;

        NoABB original = lista.get(meio);
        NoABB novo = new NoABB(original.getNome());
        novo.setReservas(original.getReservas());

        novo.setEsq(construirBalanceada(lista, inicio, meio - 1));
        novo.setDir(construirBalanceada(lista, meio + 1, fim));

        return novo;
    }

    public void balancear(){
        if (raiz == null) return;

        ArrayList<NoABB> lista = new ArrayList<>();
        camCentral(raiz, lista);

        raiz = construirBalanceada(lista, 0, lista.size() - 1);
    }

    public ArrayList<Reserva> pesquisar(String nomeBuscado) {

        if (nomeBuscado == null || nomeBuscado.isEmpty())
            return new ArrayList<>();

        NoABB atual = raiz;

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
