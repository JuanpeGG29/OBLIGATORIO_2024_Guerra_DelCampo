package Entities;

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
}
