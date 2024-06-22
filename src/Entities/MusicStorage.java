package Entities;

import TADs.BinarySearchTree.BinaryTree;
import TADs.BinarySearchTree.SearchBinaryTreeImpl;
import TADs.Hash.MyHash;
import TADs.Hash.MyHashImpl;

public class MusicStorage {
    private MyHash<String, Cancion> cancionesPorID;
    private BinaryTree<FechaCanciones> cancionesPorFecha;
    private MyHash<String, BinaryTree<FechaCanciones>> cancionesPorPaisYFecha;

    public MusicStorage() {
        this.cancionesPorID = new MyHashImpl<>();
        this.cancionesPorFecha = new SearchBinaryTreeImpl<>();
        this.cancionesPorPaisYFecha = new MyHashImpl<>();
    }

    public MyHash<String, Cancion> getCancionesPorID() {
        return cancionesPorID;
    }

    public void setCancionesPorID(MyHash<String, Cancion> cancionesPorID) {
        this.cancionesPorID = cancionesPorID;
    }

    public BinaryTree<FechaCanciones> getCancionesPorFecha() {
        return cancionesPorFecha;
    }

    public void setCancionesPorFecha(BinaryTree<FechaCanciones> cancionesPorFecha) {
        this.cancionesPorFecha = cancionesPorFecha;
    }

    public MyHash<String, BinaryTree<FechaCanciones>> getCancionesPorPaisYFecha() {
        return cancionesPorPaisYFecha;
    }

    public void setCancionesPorPaisYFecha(MyHash<String, BinaryTree<FechaCanciones>> cancionesPorPaisYFecha) {
        this.cancionesPorPaisYFecha = cancionesPorPaisYFecha;
    }

    public void agregarCancion(Cancion cancion) {
        cancionesPorID.put(cancion.getSpotify_id(), cancion);

        // Manejar cancionesPorFecha
        FechaCanciones fechaCanciones = new FechaCanciones(cancion.getSnapshot_date());
        if (!cancionesPorFecha.contains(fechaCanciones)) {
            cancionesPorFecha.add(fechaCanciones);
        }
        FechaCanciones nodo = cancionesPorFecha.find(fechaCanciones);
        nodo.agregarCancion(cancion);

        // Manejar cancionesPorPaisYFecha
        if (!cancionesPorPaisYFecha.contains(cancion.getCountry())) {
            cancionesPorPaisYFecha.put(cancion.getCountry(), new SearchBinaryTreeImpl<>());
        }
        BinaryTree<FechaCanciones> arbolFechas = cancionesPorPaisYFecha.get(cancion.getCountry());
        if (!arbolFechas.contains(fechaCanciones)) {
            arbolFechas.add(fechaCanciones);
        }
        FechaCanciones nodoPais = arbolFechas.find(fechaCanciones);
        nodoPais.agregarCancion(cancion);
    }

}
