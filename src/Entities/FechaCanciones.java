package Entities;

import TADs.LinkedList.MyLinkedListImpl;
import TADs.LinkedList.MyList;

import java.time.LocalDate;

public class FechaCanciones implements Comparable<FechaCanciones> {
    private LocalDate fecha;
    private MyList<Cancion> canciones;

    public FechaCanciones(LocalDate fecha) {
        this.fecha = fecha;
        this.canciones = new MyLinkedListImpl<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public MyList<Cancion> getCanciones() {
        return canciones;
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    @Override
    public int compareTo(FechaCanciones otra) {
        return this.fecha.compareTo(otra.getFecha());
    }
}