package lesson4;

public class TestMain4 {

    public static void main(String[] args) {
        testLinkedList();
    }

    private static void testLinkedList() {

        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);

        //ДОЛЖНО РАБОТАТЬ! Iterable - LinkedListIterator impl Iterator

        for (Integer value : linkedList) {
            System.out.println("value: " + value);
        }
        TwoSideLinkedListDequeImpl<Integer> deque = new TwoSideLinkedListDequeImpl<>();
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        deque.insertLeft(5);
        deque.insertLeft(6);
        deque.insertLeft(7);
        deque.insertLeft(8);
        deque.insertRight(8);
        deque.removeRight();
        deque.insertRight(18);
        deque.display();

    }
}
