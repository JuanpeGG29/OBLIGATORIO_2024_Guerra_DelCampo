package TADs.Stack;

import TADs.Stack.exceptions.EmptyStackException;

public interface MyStack<T> {

    void push(T value);

    T pop() throws EmptyStackException;

    T peek();

    int size();

    boolean isEmpty();
}
