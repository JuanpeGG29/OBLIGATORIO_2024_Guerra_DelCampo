package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FechaCanciones implements Comparable<FechaCanciones> {
    private LocalDate fecha;
    private List<Cancion> canciones;

    public FechaCanciones(LocalDate fecha) {
        this.fecha = fecha;
        this.canciones = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<Cancion> getCanciones() {
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