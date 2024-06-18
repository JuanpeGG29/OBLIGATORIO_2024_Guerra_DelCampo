import Entities.*;
import Exceptions.NoHayCancionEnEstaFecha;
import TADs.LinkedList.MyLinkedListImpl;
import TADs.LinkedList.MyList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public static void top10PaisFecha(MusicStorage musicStorage, String pais, LocalDate fecha) throws NoHayCancionEnEstaFecha {

        FechaCanciones cancionesFechaIndicadaTemp = new FechaCanciones(fecha);
        FechaCanciones cancionesFechaIndicada = musicStorage.getCancionesPorFecha().find(cancionesFechaIndicadaTemp);

        if (cancionesFechaIndicada == null){
            throw new NoHayCancionEnEstaFecha();
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
            for (int j = 0; j < listaOrdenada.get(i).getArtistas().size(); j++) {
                System.out.println(listaOrdenada.get(i).getArtistas().get(j));
            }
        }
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
                        top10PaisFecha(musicStorage, pais, fechaEnFormato);
                    } catch (NoHayCancionEnEstaFecha e) {
                        System.out.println("No hay canciones en la fecha indicada");;
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la fecha (MM/DD/YYYY):");
                    String fecha2 = scanner.nextLine();
                    // Llama a la función que maneja esta consulta
                    // ejemplo: mostrarTop5CancionesEnMasTop50(musicStorage, fecha2);
                    break;
                case 3:
                    System.out.println("Ingrese la fecha de inicio (MM/DD/YYYY):");
                    String fechaInicio = scanner.nextLine();
                    System.out.println("Ingrese la fecha de fin (MM/DD/YYYY):");
                    String fechaFin = scanner.nextLine();
                    // Llama a la función que maneja esta consulta
                    // ejemplo: mostrarTop7ArtistasEnRangoFechas(musicStorage, fechaInicio, fechaFin);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del artista:");
                    String artista = scanner.nextLine();
                    System.out.println("Ingrese la fecha (MM/DD/YYYY):");
                    String fecha3 = scanner.nextLine();
                    // Llama a la función que maneja esta consulta
                    // ejemplo: mostrarCantidadAparicionesArtista(musicStorage, artista, fecha3);
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
                    // Llama a la función que maneja esta consulta
                    // ejemplo: mostrarCantidadCancionesConTempoEnRango(musicStorage, tempoMin, tempoMax, fechaInicio2, fechaFin2);
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
