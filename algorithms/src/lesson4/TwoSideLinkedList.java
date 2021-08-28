package lesson4;

public interface TwoSideLinkedList<E> extends LinkedList<E> {

    void insertLast(E value);
    void insertFirst(E value);
    E removeLast();
    E getLast();

}
