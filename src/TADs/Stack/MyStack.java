package TADs.Stack;

import TADs.Stack.exceptions.EmptyStackException;

public interface MyStack <T> {

    boolean isEmpty();
    void push(T elemento);
    T pop() throws EmptyStackException;
    T top();
    int size();
    void makeEmpty() throws EmptyStackException;
    boolean contains(T value);

}
