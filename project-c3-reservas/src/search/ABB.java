package search;

import model.Reserva;
import java.util.ArrayList;
import java.util.Stack;

public class ABB {

    private NoABB raiz = null;

    public void inserir(Reserva r){
        String nome =r.getNome().trim();

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

    private void camCentralIterativa(NoABB no, ArrayList<NoABB> lista){
        Stack<NoABB> stack = new Stack<>();
        NoABB atual = raiz;

        while (true) {
            while (atual != null) {
                stack.push(atual);
                atual = atual.getEsq();
            }

            if (stack.isEmpty()) {
                break;
            }

            atual = stack.pop();
            lista.add(atual);
            atual = atual.getDir();
        }
    }

    private NoABB construirBalanceada(ArrayList<NoABB> lista, int inicio, int fim){
        if (inicio > fim){
            return null;
        }
        int meio = (inicio + fim) / 2;

        NoABB raiz = lista.get(meio);


        raiz.setEsq(construirBalanceada(lista, inicio, meio - 1));
        raiz.setDir(construirBalanceada(lista, meio + 1, fim));

        return raiz;
    }

    public void balancear(){
        if (raiz == null) {
            return;
        }

        ArrayList<NoABB> lista = new ArrayList<>();
        camCentralIterativa(raiz, lista);

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
