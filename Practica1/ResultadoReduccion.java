package Practica1;

import java.util.List;

public class ResultadoReduccion {
    public final Grafica grafica;
    public final int k;
    public final List<Integer> verticesOriginales;
    public final List<Integer> verticesNuevos;
    public final List<int[]> aristasOriginales;
    public final List<int[]> aristasNuevas;

    public ResultadoReduccion(Grafica grafica, int k, List<Integer> verticesOriginales,
                              List<Integer> verticesNuevos, List<int[]> aristasOriginales,
                              List<int[]> aristasNuevas) {
        this.grafica = grafica;
        this.k = k;
        this.verticesOriginales = verticesOriginales;
        this.verticesNuevos = verticesNuevos;
        this.aristasOriginales = aristasOriginales;
        this.aristasNuevas = aristasNuevas;
    }
}
