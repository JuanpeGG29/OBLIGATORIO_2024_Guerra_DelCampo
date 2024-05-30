package Entities;

import java.util.HashMap;

public class ArtistStorage {
    private HashMap<String, Artista> artistasPorNombre; //asumo que los nombres de los artistas son unicos y esa sera mi key

    public ArtistStorage() {
        this.artistasPorNombre = new HashMap<>();
    }

    public void agregarArtista(Artista artista) {
        artistasPorNombre.putIfAbsent(artista.getName(), artista);
    }
    public boolean contieneArtista(String nombre) {
        return artistasPorNombre.containsKey(nombre);
    }

}
