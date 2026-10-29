package Practica1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


// Leemos el archivo primero leemos el valor de K, despues los vertices y por ultimo las aristas
public class Lector {

    public static VertexCode leer(String ruta) throws IOException {
        Set<Integer> ids = new LinkedHashSet<>();
        List<int[]> aristas = new ArrayList<>();
        Set<String> vistas = new HashSet<>();
        Integer k = null;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int num = 0;
            while ((linea = br.readLine()) != null) {
                num++;
                int c = linea.indexOf('#');
                if (c >= 0) linea = linea.substring(0, c);
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                String[] p = linea.split("\\s+");
                try {
                    if (p[0].equals("k") && p.length == 2) {
                        k = Integer.parseInt(p[1]);
                    } else if (p[0].equals("V")) {
                        for (int i = 1; i < p.length; i++) ids.add(Integer.parseInt(p[i]));
                    } else if (p.length == 2) {
                        int u = Integer.parseInt(p[0]);
                        int v = Integer.parseInt(p[1]);
                        if (u == v) {
                            throw new IllegalArgumentException("Linea " + num + ": lazo no permitido (" + u + ", " + v + ")");
                        }
                        ids.add(u);
                        ids.add(v);
                        String clave = Math.min(u, v) + "-" + Math.max(u, v);
                        if (vistas.add(clave)) aristas.add(new int[]{u, v}); // ignora repetidas
                    } else {
                        throw new IllegalArgumentException("Linea " + num + ": formato invalido: '" + linea + "'");
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Linea " + num + ": se esperaban enteros: '" + linea + "'");
                }
            }
        }

        if (k == null) throw new IllegalArgumentException("El archivo no define k (linea 'k <entero>').");
        if (k < 0) throw new IllegalArgumentException("k no puede ser negativo.");

        Grafica g = new Grafica();
        for (int id : ids) g.agregarNodo(new Nodo(id));
        for (int[] a : aristas) g.agregarVecino(a[0], a[1]);

        return new VertexCode(g, new ArrayList<>(ids), aristas, k);
    }
}
