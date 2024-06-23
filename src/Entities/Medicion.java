package Entities;

public class Medicion {
    public static long getMedidaMemoria() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
    public static long getMedidaTiempo() {
        return System.nanoTime();
    }
}
