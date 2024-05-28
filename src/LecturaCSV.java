import Entities.Artista;
import Entities.Cancion;
import TADs.LinkedList.MyLinkedList;
import TADs.LinkedList.MyLinkedListImpl;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;


public class LecturaCSV {
    public static void main(String[] args) {
        String archivoCSV = "sources/universal_top_spotify_songs.csv";
        LinkedList<Cancion> canciones = new LinkedList<>(); //yo creo que a futuro es un hash o algo asi

        try (CSVReader reader = new CSVReader(new FileReader(archivoCSV))) {
            String[] nextLine;
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                Cancion cancion = crearInstanciaCancion(nextLine);
                canciones.add(cancion);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        // Imprimir las primeras 20 canciones para probar que onda
        int limite = Math.min(20, canciones.size());
        for (int i = 0; i < limite; i++) {
            Cancion cancion = canciones.get(i);
            System.out.println(cancion.toString());
        }
    }
    private static Cancion crearInstanciaCancion(String[] linea) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        MyLinkedList<Artista> artistas = new MyLinkedListImpl<>();
        String[] artistasNombres = linea[2].split(", ");
        for (String nombre : artistasNombres) {
            artistas.add(new Artista(nombre));
        }

        String country;
        if (linea[6].isEmpty()) {
            country = "global";
        } else {
            country = linea[6];
        }
        // Verificar si el campo 'snapshot_date' está vacío antes de parsearlo
        LocalDate snapshotDate;
        if (linea[7].isEmpty()) {
            snapshotDate = null;
        } else {
            snapshotDate = LocalDate.parse(linea[7], formatter);
        }

        // Verificar si el campo 'album_release_date' está vacío antes de parsearlo
        LocalDate albumReleaseDate;
        if (linea[12].isEmpty()) {
            albumReleaseDate = null;
        } else {
            albumReleaseDate = LocalDate.parse(linea[12], formatter);
        }

        return new Cancion(
                linea[0],  // spotify_id
                linea[1],  // titulo
                artistas,  // artistas
                Integer.parseInt(linea[3]),  // daily_rank
                Integer.parseInt(linea[4]),  // daily_movement (nuevo campo)
                Integer.parseInt(linea[5]),  // weekly_rank
                country,  // country
                snapshotDate,  // snapshot_date
                Integer.parseInt(linea[8]),  // popularity
                Boolean.parseBoolean(linea[9]),  // is_explicit
                Integer.parseInt(linea[10]),  // duration_ms
                linea[11],  // album_name
                albumReleaseDate,  // album_release_date
                Float.parseFloat(linea[13]),  // danceability
                Float.parseFloat(linea[14]),  // energy
                Integer.parseInt(linea[15]),  // key
                Float.parseFloat(linea[16]),  // loudness
                Integer.parseInt(linea[17]),  // mode
                Float.parseFloat(linea[18]),  // speechiness
                Float.parseFloat(linea[19]),  // acousticness
                Float.parseFloat(linea[20]),  // instrumentalness
                Float.parseFloat(linea[21]),  // liveness
                Float.parseFloat(linea[22]),  // valence
                Float.parseFloat(linea[23]),  // tempo
                Integer.parseInt(linea[24])   // time_signature
        );
    }
}
