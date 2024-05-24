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
            // Leer la primera línea (cabeceras) y descartarla
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                Cancion cancion = crearInstanciaCancion(nextLine);
                canciones.add(cancion);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        // Imprimir las primeras 20 canciones para verificar
        int limite = Math.min(20, canciones.size());
        for (int i = 0; i < limite; i++) {
            Cancion cancion = canciones.get(i);
            System.out.println(cancion.toString());
        }

    }
    private static Cancion crearInstanciaCancion(String[] linea) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        MyLinkedList<Artista> artistas = new MyLinkedListImpl<>();
        String[] artistasNombres = linea[2].split(", ");
        for (String nombre : artistasNombres) {
            artistas.add(new Artista(nombre));
        }

        return new Cancion(
                linea[0],  // spotify_id
                linea[1],  // titulo
                artistas,  // artistas
                Integer.parseInt(linea[3]),  // daily_rank
                Integer.parseInt(linea[4]),  // weekly_rank
                linea[5],  // country
                LocalDate.parse(linea[6], formatter),  // snapshot_date
                Integer.parseInt(linea[7]),  // popularity
                Boolean.parseBoolean(linea[8]),  // is_explicit
                Integer.parseInt(linea[9]),  // duration_ms
                linea[10],  // album_name
                LocalDate.parse(linea[11], formatter),  // album_release_date
                Float.parseFloat(linea[12]),  // danceability
                Float.parseFloat(linea[13]),  // energy
                Integer.parseInt(linea[14]),  // key
                Float.parseFloat(linea[15]),  // loudness
                Integer.parseInt(linea[16]),  // mode
                Float.parseFloat(linea[17]),  // speechiness
                Float.parseFloat(linea[18]),  // acousticness
                Float.parseFloat(linea[19]),  // instrumentalness
                Float.parseFloat(linea[20]),  // liveness
                Float.parseFloat(linea[21]),  // valence
                Float.parseFloat(linea[22]),  // tempo
                Integer.parseInt(linea[23])   // time_signature
        );
    }
}
