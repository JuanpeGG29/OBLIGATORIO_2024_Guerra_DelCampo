package TADs.LinkedList;

public interface MyLinkedList<T> {
    public void add(T value);

    public boolean remove(int position);

    public T get(int position);

    public int size();

    boolean isEmpty();

    boolean contains(T value);

    public void addFirst(T value);

    void addLast(T value);
    public void addpos(int position, T value);
}
