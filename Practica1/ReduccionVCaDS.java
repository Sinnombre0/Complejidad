package Practica1;

import java.util.ArrayList;
import java.util.List;

/**
 * Reduccion polinomial Vertex Cover -> Dominating Set.
 *  1. Se parte de G.
 *  2. Por cada arista (v,w) se agrega un vertice nuevo vw.
 *  3. vw se conecta con v y w; la arista (v,w) se conserva (triangulo).
 *  4. k se conserva.
 */
public class ReduccionVCaDS {

    public static ResultadoReduccion reducir(EjemplarVC ejemplar) {
        Grafica gp = new Grafica();
        List<Integer> originales = new ArrayList<>(ejemplar.getVertices());
        List<int[]> aristasOriginales = new ArrayList<>();

        // Copia de G (vertices y aristas originales)
        int maxId = Integer.MIN_VALUE;
        for (int id : originales) {
            gp.agregarNodo(new Nodo(id));
            maxId = Math.max(maxId, id);
        }
        for (int[] a : ejemplar.getAristas()) {
            gp.agregarVecino(a[0], a[1]);
            aristasOriginales.add(new int[]{a[0], a[1]});
        }

        // Un vertice nuevo por cada arista; sus ids empiezan despues del mayor id original
        List<Integer> nuevos = new ArrayList<>();
        List<int[]> aristasNuevas = new ArrayList<>();
        int siguienteId = originales.isEmpty() ? 1 : maxId + 1;

        for (int[] a : ejemplar.getAristas()) {
            int vw = siguienteId++;
            gp.agregarNodo(new Nodo(vw));
            gp.agregarVecino(a[0], vw);
            gp.agregarVecino(a[1], vw);
            nuevos.add(vw);
            aristasNuevas.add(new int[]{a[0], vw});
            aristasNuevas.add(new int[]{a[1], vw});
        }

        return new ResultadoReduccion(gp, ejemplar.getK(), originales, nuevos,
                aristasOriginales, aristasNuevas);
    }
}
