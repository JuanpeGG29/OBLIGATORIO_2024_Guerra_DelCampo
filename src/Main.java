import Entities.ArtistStorage;
import Entities.LecturaCSV;
import Entities.MusicStorage;

import java.util.Scanner;

public class Main {
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
                    // Llama a la función que maneja esta consulta
                    // ejemplo: mostrarTop10CancionesEnPais(musicStorage, pais, fecha);
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
