package Practica1;

import java.util.ArrayList;
import java.util.List;

public class ReduccionVCaDS {

    public static ResultadoReduccion reduce(VertexCode vc) {
        Grafica gp = new Grafica();
        List<Integer> originales = new ArrayList<>(vc.getVertices());
        List<int[]> aristasOriginales = new ArrayList<>();

        // Copiamos la grafica original
        int maxId = Integer.MIN_VALUE;
        for (int id : originales) {
            gp.agregarNodo(new Nodo(id));
            maxId = Math.max(maxId, id);
        }
        for (int[] a : vc.getAristas()) {
            gp.agregarVecino(a[0], a[1]);
            aristasOriginales.add(new int[]{a[0], a[1]});
        }

        // Por cada arista agregamos un vertice nuevo
        List<Integer> nuevos = new ArrayList<>();
        List<int[]> aristasNuevas = new ArrayList<>();
        int siguienteId = originales.isEmpty() ? 1 : maxId + 1;

        for (int[] a : vc.getAristas()) {
            int vw = siguienteId++;
            gp.agregarNodo(new Nodo(vw));
            gp.agregarVecino(a[0], vw);
            gp.agregarVecino(a[1], vw);
            nuevos.add(vw);
            aristasNuevas.add(new int[]{a[0], vw});
            aristasNuevas.add(new int[]{a[1], vw});
        }

        return new ResultadoReduccion(gp, vc.getK(), originales, nuevos,
                aristasOriginales, aristasNuevas);
    }
}
