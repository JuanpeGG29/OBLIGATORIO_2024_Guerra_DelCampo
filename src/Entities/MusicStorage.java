package Entities;

import java.time.LocalDate;
import java.util.*;

public class MusicStorage {
    private HashMap<String, Cancion> cancionesPorID;
    private TreeMap<LocalDate, List<Cancion>> cancionesPorFecha;
    private HashMap<String, TreeMap<LocalDate, List<Cancion>>> cancionesPorPaisYFecha;

    public MusicStorage() {
        this.cancionesPorID = new HashMap<>();
        this.cancionesPorFecha = new TreeMap<>();
        this.cancionesPorPaisYFecha = new HashMap<>();
    }

    public void agregarCancion(Cancion cancion) {
        cancionesPorID.put(cancion.getSpotify_id(), cancion);

        cancionesPorFecha.putIfAbsent(cancion.getSnapshot_date(), new ArrayList<>());
        cancionesPorFecha.get(cancion.getSnapshot_date()).add(cancion);

        cancionesPorPaisYFecha.putIfAbsent(cancion.getCountry(), new TreeMap<>());
        TreeMap<LocalDate, List<Cancion>> fechas = cancionesPorPaisYFecha.get(cancion.getCountry());
        fechas.putIfAbsent(cancion.getSnapshot_date(), new ArrayList<>());
        fechas.get(cancion.getSnapshot_date()).add(cancion);
    }

}
