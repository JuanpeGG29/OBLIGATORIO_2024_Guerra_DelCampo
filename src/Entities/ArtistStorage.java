package Entities;

import TADs.Hash.MyHash;
import TADs.Hash.MyHashImpl;

public class ArtistStorage {
    private MyHash<String, Artista> artistasPorNombre; //asumo que los nombres de los artistas son unicos y esa sera mi key

    public ArtistStorage() {
        this.artistasPorNombre = new MyHashImpl<>();
    }

    public void agregarArtista(Artista artista) {
        artistasPorNombre.put(artista.getName(), artista);
    }
    public boolean contieneArtista(String nombre) {
        return artistasPorNombre.contains(nombre);
    }

}
