package Entities;

import java.util.Map;

public class CancionEntry implements Comparable<CancionEntry> {
    private Map.Entry<Cancion, Integer> entry;

    public CancionEntry(Map.Entry<Cancion, Integer> entry) {
        this.entry = entry;
    }

    public Map.Entry<Cancion, Integer> getEntry() {
        return entry;
    }

    @Override
    public int compareTo(CancionEntry other) {
        // Comparar en orden descendente por el valor de apariciones
        return other.entry.getValue().compareTo(this.entry.getValue());
    }
}
