package TADs.ArrayList;

import java.util.Comparator;

public interface MyArrayList<T> {
    void add(T value);
    T get (int posicion);
    void delete(T value);
    boolean contains(T value);
    int size();

    void sort(Comparator<T> comparator);
}
