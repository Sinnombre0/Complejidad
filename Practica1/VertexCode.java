package Practica1;

import java.util.List;

public class VertexCode {
    private final Grafica grafica;
    private final List<Integer> vertices;
    private final List<int[]> aristas;
    private final int k;

    public VertexCode(Grafica grafica, List<Integer> vertices, List<int[]> aristas, int k) {
        this.grafica = grafica;
        this.vertices = vertices;
        this.aristas = aristas;
        this.k = k;
    }

    public Grafica getGrafica() { return grafica; }
    public List<Integer> getVertices() { return vertices; }
    public List<int[]> getAristas() { return aristas; }
    public int getK() { return k; }
}
