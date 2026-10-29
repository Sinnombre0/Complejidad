package Practica1;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Practica1.Main <archivo_ejemplar>");
            System.exit(1);
        }

        VertexCode ejemplar;
        try {
            ejemplar = Lector.leer(args[0]);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
            return;
        }

        imprimir(ReduccionVCaDS.reduce(ejemplar));
    }

    private static void imprimir(ResultadoReduccion r) {
        System.out.println("=== Conjunto Dominante (G', k) ===");
        System.out.println("Vertices originales (" + r.verticesOriginales.size() + "): " + r.verticesOriginales);

        System.out.println("Vertices nuevos (" + r.verticesNuevos.size() + "):");
        for (int i = 0; i < r.verticesNuevos.size(); i++) {
            int[] a = r.aristasOriginales.get(i);
            System.out.println("  " + r.verticesNuevos.get(i) + "  (asociado a la arista (" + a[0] + ", " + a[1] + "))");
        }

        imprimirAristas("Aristas originales", r.aristasOriginales);
        imprimirAristas("Aristas nuevas", r.aristasNuevas);
        System.out.println("k = " + r.k);
    }

    private static void imprimirAristas(String titulo, List<int[]> aristas) {
        System.out.println(titulo + " (" + aristas.size() + "):");
        for (int[] a : aristas) {
            System.out.println("  (" + a[0] + ", " + a[1] + ")");
        }
    }
}
