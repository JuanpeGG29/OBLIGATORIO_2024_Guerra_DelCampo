package TADs.Heap;

import TADs.Heap.exceptions.EmptyHeapException;

public interface MyHeap  <T extends Comparable<T>> {
    void insert(T value);
    T delete() throws EmptyHeapException;
    int size();
    boolean isEmpty();
}
