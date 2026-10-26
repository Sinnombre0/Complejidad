package Practica1;
import java.util.ArrayList;
import java.util.List;

public class Grafica {

    private final List<Nodo> nodos;

    public Grafica() {
        this.nodos = new ArrayList<>();
    }

    public Grafica(List<Nodo> nodos) {
        this.nodos = new ArrayList<>();
        for (Nodo nodo : nodos) {
            agregarNodo(nodo);
        }
    }

    public void agregarNodo(Nodo nodo) {
        if (buscarNodo(nodo.getId()) != null) {
            throw new IllegalArgumentException("Ya existe el nodo con el id " + nodo.getId() + ".");
        }
        nodos.add(nodo);
    }

    public void agregarVecino(int idNodo, int idVecino) {
        Nodo nodo = buscarNodo(idNodo);
        Nodo vecino = buscarNodo(idVecino);

        nodo.agregarVecino(vecino);
    }

    public void consultarVecinosDeUnNodo(int id) {
        Nodo nodo = buscarNodo(id);
        if (nodo == null) {
            System.out.println("El nodo " + id + " no existe.");
            return;
        }

        System.out.println("Vecinos del nodo " + id + ":");
        for (Nodo vecino : nodo.getVecinos()) {
            System.out.println("Nodo vecino: " + vecino.getId());
        }
    }

    public void consultarVecinos() {
        for (Nodo nodo : nodos) {
            consultarVecinosDeUnNodo(nodo.getId());
        }
    }

    private Nodo buscarNodo(int id) {
        for (Nodo nodo : nodos) {
            if (nodo.getId() == id) {
                return nodo;
            }
        }
        return null;
    }
}
