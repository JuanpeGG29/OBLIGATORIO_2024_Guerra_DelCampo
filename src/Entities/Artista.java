package Entities;

import TADs.LinkedList.MyLinkedList;
import TADs.LinkedList.MyLinkedListImpl;

public class Artista {
   private String name;
   private MyLinkedList<Album> albumes;
   private MyLinkedList<Cancion> canciones;

    public Artista(String name) {
        this.name = name;
        this.albumes = new MyLinkedListImpl<>();
        this.canciones = new MyLinkedListImpl<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyLinkedList<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(MyLinkedList<Album> albumes) {
        this.albumes = albumes;
    }

    public MyLinkedList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(MyLinkedList<Cancion> canciones) {
        this.canciones = canciones;
    }
}
