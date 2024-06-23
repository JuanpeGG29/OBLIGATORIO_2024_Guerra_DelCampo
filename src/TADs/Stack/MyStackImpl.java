package TADs.Stack;

import TADs.Stack.exceptions.EmptyStackException;
import TADs.LinkedList.MyLinkedListImpl;
import TADs.LinkedList.MyList;

public class MyStackImpl<T> implements MyStack<T> {
    private MyList<T> list;

    public MyStackImpl() {
        list = new MyLinkedListImpl<>();
    }

    @Override
    public void push(T value) {
        list.add(value);
    }

    @Override
    public T pop() throws EmptyStackException {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        T value = list.get(list.size() - 1);
        list.remove(value);
        return value;
    }

    @Override
    public T peek() {
        return list.get(list.size() - 1);
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
