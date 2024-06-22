package Entities;

import java.util.Map;

public class ArtistaEntry implements Comparable<ArtistaEntry> {
    private Map.Entry<String, Integer> entry;

    public ArtistaEntry(Map.Entry<String, Integer> entry) {
        this.entry = entry;
    }

    public Map.Entry<String, Integer> getEntry() {
        return entry;
    }

    @Override
    public int compareTo(ArtistaEntry other) {
        // Comparar en orden descendente por el valor de apariciones
        return other.entry.getValue().compareTo(this.entry.getValue());
    }
}
