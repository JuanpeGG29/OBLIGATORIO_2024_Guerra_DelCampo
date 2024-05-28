package Entities;

import java.util.HashMap;

public class ArtistStorage {
    private HashMap<String, Artista> artistasPorNombre;

    public ArtistStorage() {
        this.artistasPorNombre = new HashMap<>();
    }

    public void agregarArtista(Artista artista) {
        artistasPorNombre.putIfAbsent(artista.getName(), artista);
    }

}
