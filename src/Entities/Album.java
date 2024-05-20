package Entities;

import TADs.LinkedList.MyLinkedList;
import TADs.LinkedList.MyLinkedListImpl;

import java.time.LocalDate;

public class Album {
    private String nombre;
    private LocalDate release_date;
    private int duration_ms;
    private MyLinkedList<Cancion> canciones;

    public Album(String nombre, LocalDate release_date, int duration_ms) {
        this.nombre = nombre;
        this.release_date = release_date;
        this.duration_ms = duration_ms;
        this.canciones = new MyLinkedListImpl<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(int duration_ms) {
        this.duration_ms = duration_ms;
    }

    public MyLinkedList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(MyLinkedList<Cancion> canciones) {
        this.canciones = canciones;
    }
}
