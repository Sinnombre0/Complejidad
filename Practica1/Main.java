package Practica1;

public class Main {
    
    public static void main(String[] args) {
        // Crear nodos
        Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        Nodo nodo3 = new Nodo(3);
        Nodo nodo4 = new Nodo(4);

        // Creamos la grafica y guardamos todos los nodos
        Grafica grafica = new Grafica();
        grafica.agregarNodo(nodo1);
        grafica.agregarNodo(nodo2);
        grafica.agregarNodo(nodo3);
        grafica.agregarNodo(nodo4);

        // Agregamos las aristas entre nodos
        grafica.agregarVecino(1, 2);
        grafica.agregarVecino(1, 3);
        grafica.agregarVecino(1, 4);
        grafica.agregarVecino(2, 4);
        grafica.agregarVecino(2, 3);

        // Consultar los vecinos de cada nodo
        grafica.consultarVecinos();
    }
}
