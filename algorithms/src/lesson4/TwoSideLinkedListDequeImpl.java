package lesson4;

import lesson3.deque.Deque;

public class TwoSideLinkedListDequeImpl<E> extends TwoSideLinkedListImpl<E> implements Deque<E> {
    private final TwoSideLinkedList<E> data;

    public TwoSideLinkedListDequeImpl() {
        this.data = new TwoSideLinkedListImpl<>();
    }


    @Override
    public boolean insertLeft(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        return data.removeLast();
    }

    @Override
    public boolean insert(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "LinkedQueueImpl{" + "data=" + data + '}';
    }
}
