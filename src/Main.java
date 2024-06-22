import Entities.*;
import Exceptions.*;
import TADs.BinarySearchTree.BinaryTree;
import TADs.Hash.MyHash;
import TADs.Hash.MyHashImpl;
import TADs.Heap.MyHeap;
import TADs.Heap.MyHeapImpl;
import TADs.Heap.exceptions.EmptyHeapException;
import TADs.LinkedList.MyLinkedListImpl;
import TADs.LinkedList.MyList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public static void top10PaisFecha(MusicStorage musicStorage, String pais, LocalDate fecha) throws NoHayCancionEnEstaFecha, NoHayCancionesParaPaisYFecha, NoHayCancionesParaElPais {
        FechaCanciones cancionesFechaIndicadaTemp = new FechaCanciones(fecha);
        FechaCanciones cancionesFechaIndicada = musicStorage.getCancionesPorFecha().find(cancionesFechaIndicadaTemp);

        if (cancionesFechaIndicada == null){
            throw new NoHayCancionEnEstaFecha();
        }

        if (!musicStorage.getCancionesPorPaisYFecha().contains(pais)) {
            throw new NoHayCancionesParaElPais();
        }

        BinaryTree<FechaCanciones> cancionesPorFechaParaPais = musicStorage.getCancionesPorPaisYFecha().get(pais);
        FechaCanciones cancionesParaPaisYFecha = cancionesPorFechaParaPais.find(cancionesFechaIndicadaTemp);

        if (cancionesParaPaisYFecha == null) {
            throw new NoHayCancionesParaPaisYFecha();
        }

        MyList<Cancion> cancionesPaisYfecha = new MyLinkedListImpl<>();
        for (int i = 0; i < cancionesFechaIndicada.getCanciones().size(); i++) {
            if (cancionesFechaIndicada.getCanciones().get(i).getCountry().equals(pais) && cancionesFechaIndicada.getCanciones().get(i).getDaily_rank() <= 10){
                cancionesPaisYfecha.add(cancionesFechaIndicada.getCanciones().get(i));
            }
        }

        MyList<Cancion> listaOrdenada = new MyLinkedListImpl<>();
        int contador = 1;
        while(contador < 11) {
            for (int i = 0; i < cancionesPaisYfecha.size(); i++) {
                if (cancionesPaisYfecha.get(i).getDaily_rank() == contador){
                    listaOrdenada.add(cancionesPaisYfecha.get(i));
                    contador ++;
                    break;
                }
            }
        }

        for (int i = 0; i < listaOrdenada.size(); i++) {
            System.out.println(listaOrdenada.get(i));
        }
    }


    public static void top5masAparicionesTOP50 (MusicStorage musicStorage, LocalDate fecha) throws NoHayCancionEnEstaFecha {
        FechaCanciones cancionesFechaIndicadaTemp = new FechaCanciones(fecha);
        FechaCanciones cancionesFechaIndicada = musicStorage.getCancionesPorFecha().find(cancionesFechaIndicadaTemp);

        if (cancionesFechaIndicada == null){
            throw new NoHayCancionEnEstaFecha();
        }

        // Hash para contar las apariciones de cada canción
        MyHash<Cancion, Integer> aparicionesCanciones = new MyHashImpl<>();

        for (int i = 0; i < cancionesFechaIndicada.getCanciones().size(); i++) {
            Cancion cancion = cancionesFechaIndicada.getCanciones().get(i);
            if (cancion.getDaily_rank() <= 50) {
                int count = 0;
                if (aparicionesCanciones.contains(cancion)) {
                    count = aparicionesCanciones.get(cancion);
                }
                aparicionesCanciones.put(cancion, count + 1);
            }
        }

        //Heap para encontrar las top 5 canciones con más apariciones
        MyHeap<CancionEntry> maxHeap = new MyHeapImpl<>(aparicionesCanciones.size());

        // Añado todas las entradas del Hash al maxHeap
        MyList<Cancion> keys = aparicionesCanciones.keys();
        for (int i = 0; i < keys.size(); i++) {
            Cancion key = keys.get(i);
            Map.Entry<Cancion, Integer> entry = new HashMap.SimpleEntry<>(key, aparicionesCanciones.get(key));
            maxHeap.insert(new CancionEntry(entry));
        }

        // Obtengo las top 5 canciones con más apariciones
        List<CancionEntry> top5 = new ArrayList<>();
        for (int i = 0; i < 5 && !maxHeap.isEmpty(); i++) {
            try {
                top5.add(maxHeap.delete());
            } catch (EmptyHeapException e) {
                throw new RuntimeException(e);
            }
        }

        for (CancionEntry entry : top5) {
            System.out.println("Canción: " + entry.getEntry().getKey().getTitulo() + ", Apariciones: " + entry.getEntry().getValue());
        }

    }

    public static void top7ArtistasRangoDeFechas(MusicStorage musicStorage, LocalDate fechaInicial, LocalDate fechaFinal) throws RangoInvalido, NoHayCancionEnEstaFecha {
        if (fechaInicial.isAfter(fechaFinal)) {
            throw new RangoInvalido();
        }

        MyHash<String, Integer> aparicionesArtistas = new MyHashImpl<>();

        FechaCanciones fechaInicio = new FechaCanciones(fechaInicial);
        FechaCanciones fechaFin = new FechaCanciones(fechaFinal);
        List<FechaCanciones> fechasEnRango = musicStorage.getCancionesPorFecha().rangeSearch(fechaInicio, fechaFin);//primo

        if (fechasEnRango.isEmpty()) {
            throw new NoHayCancionEnEstaFecha();
        }

        for (FechaCanciones fechaCanciones : fechasEnRango) {
            MyList<Cancion> canciones = fechaCanciones.getCanciones();
            for (int j = 0; j < canciones.size(); j++) {
                Cancion cancion = canciones.get(j);
                MyList<Artista> artistas = cancion.getArtistas();
                for (int k = 0; k < artistas.size(); k++) {
                    Artista artista = artistas.get(k);
                    String nombreArtista = artista.getName();
                    int count = 0;
                    if (aparicionesArtistas.contains(nombreArtista)) {
                        count = aparicionesArtistas.get(nombreArtista);
                    }
                    aparicionesArtistas.put(nombreArtista, count + 1);
                }
            }
        }

        // max heap para encontrar los top 7 artistas con más apariciones
        MyHeap<ArtistaEntry> maxHeap = new MyHeapImpl<>(aparicionesArtistas.size());
        MyList<String> artistasKeys = aparicionesArtistas.keys();
        for (int i = 0; i < artistasKeys.size(); i++) {
            String key = artistasKeys.get(i);
            Map.Entry<String, Integer> entry = new HashMap.SimpleEntry<>(key, aparicionesArtistas.get(key));
            maxHeap.insert(new ArtistaEntry(entry));
        }

        System.out.println("Top 7 artistas con más apariciones en el rango de fechas:");
        for (int i = 0; i < 7 && !maxHeap.isEmpty(); i++) {
            try {
                ArtistaEntry entry = maxHeap.delete();
                System.out.println("Artista: " + entry.getEntry().getKey() + ", Apariciones: " + entry.getEntry().getValue());
            } catch (EmptyHeapException e) {
                e.printStackTrace();
            }
        }
    }


    public static void cantidadAparicionesArtista (MusicStorage musicStorage, ArtistStorage artistStorage, String nombreArtista, String pais, LocalDate fecha) throws NoHayCancionEnEstaFecha, NoHayCancionesParaElPais, NoExisteArtista, NoHayCancionesParaPaisYFecha {
        FechaCanciones cancionesFechaIndicadaTemp = new FechaCanciones(fecha);
        FechaCanciones cancionesFechaIndicada = musicStorage.getCancionesPorFecha().find(cancionesFechaIndicadaTemp);

        if (cancionesFechaIndicada == null){
            throw new NoHayCancionEnEstaFecha();
        }

        if (!musicStorage.getCancionesPorPaisYFecha().contains(pais)) {
            throw new NoHayCancionesParaElPais();
        }

        Artista artista = artistStorage.getArtistasPorNombre().get(nombreArtista);

        if (artista == null){
            throw new NoExisteArtista();
        }

        BinaryTree<FechaCanciones> cancionesPorFechaParaPais = musicStorage.getCancionesPorPaisYFecha().get(pais);
        FechaCanciones cancionesParaPaisYFecha = cancionesPorFechaParaPais.find(cancionesFechaIndicadaTemp);

        if (cancionesParaPaisYFecha == null) {
            throw new NoHayCancionesParaPaisYFecha();
        }

        MyList<Cancion> listaCanciones = cancionesParaPaisYFecha.getCanciones();

        int contador = 0;
        for (int i = 0; i < listaCanciones.size(); i++) {
            for (int j = 0; j < listaCanciones.get(i).getArtistas().size(); j++) {
                if (artista.equals(listaCanciones.get(i).getArtistas().get(j))){
                    contador ++;
                }
            }
        }

        System.out.println(nombreArtista + ": " + contador);
    }

    public static void cantidadCancionesPorTempoYRangoDeFechas(MusicStorage musicStorage, float tempoMin, float tempoMax, LocalDate fechaInicial, LocalDate fechaFinal) throws NoHayCancionesParaEsteRangoDeFechas, RangoInvalido {
        if (fechaInicial.isAfter(fechaFinal)) {
            throw new RangoInvalido();
        }

        if (tempoMin > tempoMax){
            throw new RangoInvalido();
        }

        FechaCanciones fechaInicio = new FechaCanciones(fechaInicial);
        FechaCanciones fechaFin = new FechaCanciones(fechaFinal);

        List<FechaCanciones> fechasEnRango = musicStorage.getCancionesPorFecha().rangeSearch(fechaInicio, fechaFin);

        if (fechasEnRango.isEmpty()) {
            throw new NoHayCancionesParaEsteRangoDeFechas();
        }

        int contador = 0;

        for (FechaCanciones fechaCanciones : fechasEnRango) {
            MyList<Cancion> canciones = fechaCanciones.getCanciones();
            for (int i = 0; i < canciones.size(); i++) {
                Cancion cancion = canciones.get(i);
                if (cancion.getTempo() >= tempoMin && cancion.getTempo() <= tempoMax) {
                    contador++;
                }
            }
        }

        System.out.println("Cantidad de canciones con tempo entre " + tempoMin + " y " + tempoMax + " en el rango de fechas: " + contador);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicStorage musicStorage = new MusicStorage();
        ArtistStorage artistStorage = new ArtistStorage();
        LecturaCSV.leerArchivo("sources/universal_top_spotify_songs.csv", musicStorage, artistStorage);



        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione una consulta:");
            System.out.println("1. Top 10 canciones en un país en un día dado.");
            System.out.println("2. Top 5 canciones que aparecen en más top 50 en un día dado.");
            System.out.println("3. Top 7 artistas que más aparecen en los top 50 para un rango de fechas dado.");
            System.out.println("4. Cantidad de veces que aparece un artista específico en un top 50 en una fecha dada.");
            System.out.println("5. Cantidad de canciones con un tempo en un rango específico para un rango específico de fechas.");
            System.out.println("6. Salir.");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el país:");
                    String pais = scanner.nextLine();
                    System.out.println("Ingrese la fecha (MM/DD/YYYY):");
                    String fecha = scanner.nextLine();
                    LocalDate fechaEnFormato = LocalDate.parse(fecha, formatter);
                    try {
                        try {
                            top10PaisFecha(musicStorage, pais, fechaEnFormato);
                        } catch (NoHayCancionesParaPaisYFecha e) {
                            System.out.println("No hay canciones para la fecha y el pais indicado");;
                        } catch (NoHayCancionesParaElPais e) {
                            System.out.println("No hay canciones para el pais indicado");;
                        }
                    } catch (NoHayCancionEnEstaFecha e) {
                        System.out.println("No hay canciones en la fecha indicada");;
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la fecha (MM/DD/YYYY):");
                    String fecha2 = scanner.nextLine();
                    LocalDate fechaEnFormato2 = LocalDate.parse(fecha2, formatter);
                    try {
                        top5masAparicionesTOP50(musicStorage, fechaEnFormato2);
                    } catch (NoHayCancionEnEstaFecha e) {
                        System.out.println("No existen canciones para la fecha indicada");;
                    }
                    break;
                case 3:
                    System.out.println("Ingrese la fecha de inicio (MM/DD/YYYY):");
                    String fechaInicio = scanner.nextLine();
                    System.out.println("Ingrese la fecha de fin (MM/DD/YYYY):");
                    String fechaFin = scanner.nextLine();
                    LocalDate fechaInicioEnFormato = LocalDate.parse(fechaInicio, formatter);
                    LocalDate fechaFinEnFormato = LocalDate.parse(fechaFin, formatter);
                    try {
                        top7ArtistasRangoDeFechas(musicStorage, fechaInicioEnFormato, fechaFinEnFormato);
                    } catch (RangoInvalido e) {
                        System.out.println("La fecha inicial no puede ser posterior a la fecha final.");;
                    } catch (NoHayCancionEnEstaFecha e) {
                        System.out.println("No hay canciones en el rango de fechas indicado.");;
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del artista:");
                    String artista = scanner.nextLine();
                    System.out.println("Ingrese pais:");
                    String pais1 = scanner.nextLine();
                    System.out.println("Ingrese la fecha (MM/DD/YYYY):");
                    String fecha3 = scanner.nextLine();
                    LocalDate fecha3EnFormato = LocalDate.parse(fecha3, formatter);
                    try {
                        cantidadAparicionesArtista(musicStorage, artistStorage, artista, pais1, fecha3EnFormato);
                    } catch (NoHayCancionEnEstaFecha e) {
                        System.out.println("No hay canciones en esta fecha");;
                    } catch (NoHayCancionesParaElPais e) {
                        System.out.println("No hay canciones para el pais");;
                    } catch (NoExisteArtista e) {
                        System.out.println("No se encuentra el artista indicado");;
                    } catch (NoHayCancionesParaPaisYFecha e) {
                        System.out.println("No hay canciones para el pais y fecha indicado");;
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el tempo mínimo:");
                    float tempoMin = scanner.nextFloat();
                    System.out.println("Ingrese el tempo máximo:");
                    float tempoMax = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Ingrese la fecha de inicio (MM/DD/YYYY):");
                    String fechaInicio2 = scanner.nextLine();
                    System.out.println("Ingrese la fecha de fin (MM/DD/YYYYY):");
                    String fechaFin2 = scanner.nextLine();
                    LocalDate fechaInicio2EnFormato = LocalDate.parse(fechaInicio2, formatter);
                    LocalDate fechaFin2EnFormato = LocalDate.parse(fechaFin2, formatter);
                    try {
                        cantidadCancionesPorTempoYRangoDeFechas(musicStorage, tempoMin, tempoMax, fechaInicio2EnFormato, fechaFin2EnFormato);
                    } catch (NoHayCancionesParaEsteRangoDeFechas e) {
                        System.out.println("No hay canciones para este rango de fechas");;
                    } catch (RangoInvalido e) {
                        System.out.println("Rango invalido");;
                    }
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
                    break;
            }
        }
        scanner.close();
    }
}
