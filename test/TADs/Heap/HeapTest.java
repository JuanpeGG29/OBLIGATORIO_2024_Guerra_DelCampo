package TADs.Heap;

import TADs.Heap.exceptions.EmptyHeapException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    @Test
    public void insertValido() {
        MyHeap<Integer> heapDePrueba = new MyHeapImpl<>(10);

        heapDePrueba.insert(5);
        heapDePrueba.insert(10);
        heapDePrueba.insert(3);
        heapDePrueba.insert(8);
        heapDePrueba.insert(7);

        assertEquals(5, heapDePrueba.size());
    }

    @Test
    public void deleteHeapConElementos() throws EmptyHeapException {
        MyHeap<Integer> heapDePrueba = new MyHeapImpl<>(10);

        heapDePrueba.insert(5);
        heapDePrueba.insert(10);
        heapDePrueba.insert(3);
        heapDePrueba.insert(8);
        heapDePrueba.insert(7);

        assertEquals(5, heapDePrueba.size());

        assertEquals(3, heapDePrueba.delete().intValue());
        assertEquals(4, heapDePrueba.size());
    }

    @Test
    public void deleteHeapVacio() throws EmptyHeapException {
        MyHeap<Integer> heapDePrueba = new MyHeapImpl<>(10);

        try {
            heapDePrueba.delete();
        } catch (EmptyHeapException e) {
            System.out.println("Empty heap");
        }
    }

    @Test
    public void sizeHeapConElementos() {
        MyHeap<Integer> heapDePrueba = new MyHeapImpl<>(10);

        heapDePrueba.insert(5);
        heapDePrueba.insert(10);
        heapDePrueba.insert(3);
        heapDePrueba.insert(8);
        heapDePrueba.insert(-1);

        assertEquals(5, heapDePrueba.size());
    }

    @Test
    public void sizeHeapVacio() {
        MyHeap<Integer> heapDePrueba = new MyHeapImpl<>(10);

        assertEquals(0, heapDePrueba.size());
    }
}

