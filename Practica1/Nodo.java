package Practica1;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    
    int id;

    List<Nodo> vecinos;

    // Constructor
    public Nodo(int id) {
        this.id = id;
        this.vecinos = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Nodo> getVecinos() {
        return vecinos;
    }

    public void setVecinos(List<Nodo> vecinos) {
        this.vecinos = vecinos;
    }

    public void agregarVecino(Nodo vecino) {
        this.vecinos.add(vecino);
    }
}