package TADs.Queue;

import TADs.Queue.exceptions.EmptyQueueException;
import TADs.LinkedList.MyList;
import TADs.LinkedList.MyLinkedListImpl;

public class MyQueueImpl<T> implements MyQueue<T> {
    private MyList<T> list;

    public MyQueueImpl() {
        list = new MyLinkedListImpl<>();
    }

    @Override
    public void enqueue(T value) {
        list.add(value);
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (list.isEmpty()) {
            throw new EmptyQueueException();
        }
        T value = list.get(0);
        list.remove(value);
        return value;
    }

    @Override
    public boolean contains(T value) {
        return list.contains(value);
    }

    @Override
    public T get(int i) {
        return list.get(i);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
