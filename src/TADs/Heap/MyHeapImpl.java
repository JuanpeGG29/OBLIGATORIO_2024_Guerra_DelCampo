package TADs.Heap;

import TADs.Heap.exceptions.EmptyHeapException;

public class MyHeapImpl<T extends Comparable<T>> implements MyHeap<T> {

    private T[] values;
    private int heapSize;

    public MyHeapImpl(int size) {
        this.values = (T[]) new Comparable[size];
        this.heapSize = 0;
    }

    private int getFatherPosition(int position) {
        return (position - 1) / 2;
    }

    private int getLeftChildPosition(int position) {
        return 2 * position + 1;
    }

    private int getRightChildPosition(int position) {
        return 2 * position + 2;
    }

    private int maxPosition(int position1, int position2) {
        if (position1 >= heapSize && position2 >= heapSize) {
            return -1; // Para que se termine de intercambiar lugares.
        }
        if (position1 < heapSize && position2 >= heapSize) {
            return position1;
        }
        if (position1 >= heapSize && position2 < heapSize) {
            return position2;
        }
        if (values[position1].compareTo(values[position2]) > 0) {
            return position1;
        } else {
            return position2;
        }
    }

    private int minPosition(int position1, int position2) {
        if (position1 >= heapSize && position2 >= heapSize) {
            return -1;
        }
        if (position1 < heapSize && position2 >= heapSize) {
            return position1;
        }
        if (position1 >= heapSize && position2 < heapSize) {
            return position2;
        }
        if (values[position1].compareTo(values[position2]) < 0) {
            return position1;
        } else {
            return position2;
        }
    }

    @Override
    public void insert(T value) {
        int position = heapSize;
        heapSize++;
        values[position] = value;
        while (position > 0 && values[position].compareTo(values[getFatherPosition(position)]) < 0) {
            T temp = values[position];
            values[position] = values[getFatherPosition(position)];
            values[getFatherPosition(position)] = temp;
            position = getFatherPosition(position);
        }
    }

    @Override
    public T delete() throws EmptyHeapException {
        if (heapSize == 0) {
            throw new EmptyHeapException();
        }
        T returnValue = values[0];
        heapSize--;
        if (heapSize > 0) {
            values[0] = values[heapSize];
            int position = 0;
            int childMinPosition = minPosition(getLeftChildPosition(position), getRightChildPosition(position));
            while (childMinPosition != -1 && values[position].compareTo(values[childMinPosition]) > 0) {
                T temp = values[position];
                values[position] = values[childMinPosition];
                values[childMinPosition] = temp;
                position = childMinPosition;
                childMinPosition = minPosition(getLeftChildPosition(position), getRightChildPosition(position));
            }
        }
        return returnValue;
    }

    @Override
    public int size() {
        return heapSize;
    }

    @Override
    public boolean isEmpty() {
        return heapSize == 0;
    }
}
