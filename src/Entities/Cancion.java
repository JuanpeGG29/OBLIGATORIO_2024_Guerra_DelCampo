package Entities;

import TADs.LinkedList.MyList;

import java.time.LocalDate;
import java.util.Objects;

public class Cancion {
    private String spotify_id;
    private String titulo;
    private MyList<Artista> artistas;
    private int daily_rank;
    private int daily_movement;
    private int weekly_rank;
    private String country;
    private LocalDate snapshot_date;
    private int popularity;
    private boolean is_explicit;
    private int duration_ms;
    private String album_name;
    private LocalDate album_release_date;
    private float danceability;
    private float energy;
    private int key;
    private float loudness;
    private int mode;
    private float speechiness;
    private float acousticness;
    private float instrumentalness;
    private float liveness;
    private float valence;
    private float tempo;
    private int time_signature;

    public Cancion(String spotify_id, String titulo, MyList<Artista> artistas, int daily_rank, int daily_movement, int weekly_rank, String country, LocalDate snapshot_date, int popularity, boolean is_explicit, int duration_ms, String album_name, LocalDate album_release_date, float danceability, float energy, int key, float loudness, int mode, float speechiness, float acousticness, float instrumentalness, float liveness, float valence, float tempo, int time_signature) {
        this.spotify_id = spotify_id;
        this.titulo = titulo;
        this.artistas = artistas;
        this.daily_rank = daily_rank;
        this.daily_movement = daily_movement;
        this.weekly_rank = weekly_rank;
        this.country = country;
        this.snapshot_date = snapshot_date;
        this.popularity = popularity;
        this.is_explicit = is_explicit;
        this.duration_ms = duration_ms;
        this.album_name = album_name;
        this.album_release_date = album_release_date;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.mode = mode;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.time_signature = time_signature;
    }

    public int getDaily_movement() {
        return daily_movement;
    }

    public void setDaily_movement(int daily_movement) {
        this.daily_movement = daily_movement;
    }

    public String getSpotify_id() {
        return spotify_id;
    }

    public void setSpotify_id(String spotify_id) {
        this.spotify_id = spotify_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDaily_rank() {
        return daily_rank;
    }

    public void setDaily_rank(int daily_rank) {
        this.daily_rank = daily_rank;
    }

    public int getWeekly_rank() {
        return weekly_rank;
    }

    public void setWeekly_rank(int weekly_rank) {
        this.weekly_rank = weekly_rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getSnapshot_date() {
        return snapshot_date;
    }

    public void setSnapshot_date(LocalDate snapshot_date) {
        this.snapshot_date = snapshot_date;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isIs_explicit() {
        return is_explicit;
    }

    public void setIs_explicit(boolean is_explicit) {
        this.is_explicit = is_explicit;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(int duration_ms) {
        this.duration_ms = duration_ms;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public LocalDate getAlbum_release_date() {
        return album_release_date;
    }

    public void setAlbum_release_date(LocalDate album_release_date) {
        this.album_release_date = album_release_date;
    }

    public float getDanceability() {
        return danceability;
    }

    public void setDanceability(float danceability) {
        this.danceability = danceability;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public float getLoudness() {
        return loudness;
    }

    public void setLoudness(float loudness) {
        this.loudness = loudness;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public float getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(float speechiness) {
        this.speechiness = speechiness;
    }

    public float getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(float acousticness) {
        this.acousticness = acousticness;
    }

    public float getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(float instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public float getLiveness() {
        return liveness;
    }

    public void setLiveness(float liveness) {
        this.liveness = liveness;
    }

    public float getValence() {
        return valence;
    }

    public void setValence(float valence) {
        this.valence = valence;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public int getTime_signature() {
        return time_signature;
    }

    public void setTime_signature(int time_signature) {
        this.time_signature = time_signature;
    }

    public MyList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(MyList<Artista> artistas) {
        this.artistas = artistas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return Objects.equals(spotify_id, cancion.spotify_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spotify_id);
    }

    @Override
    public String toString() {
        StringBuilder artistasStr = new StringBuilder();
        for (int i = 0; i < this.getArtistas().size(); i++) {
            if (i > 0) {
                artistasStr.append(", ");
            }
            artistasStr.append(this.getArtistas().get(i).getName());
        }
        return "daily_rank=" + daily_rank +
                ", titulo='" + titulo + '\'' +
                ", artistas=[" + artistasStr.toString() + "]";
    }
}