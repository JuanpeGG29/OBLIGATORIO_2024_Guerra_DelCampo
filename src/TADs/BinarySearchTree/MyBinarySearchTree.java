package TADs.BinarySearchTree;

import TADs.LinkedList.MyLinkedList;

public interface MyBinarySearchTree <K extends Comparable <K>, T> {

    T find (K key);
    void insert (K key, T data);
    void delete (K key);
    int size();

    MyLinkedList<K> inOrder();

}
