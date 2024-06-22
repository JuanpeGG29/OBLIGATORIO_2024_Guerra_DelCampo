package Entities;

import java.util.Objects;

public class Artista {
   private String name;

    public Artista(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(name, artista.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
