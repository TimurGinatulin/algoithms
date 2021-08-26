import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deq<Integer> deque = new Deq<>(5);
        deque.insertLeft(1);
       deque.insertLeft(2);
        deque.insertRight(3);
        deque.removeLeft();
        deque.insertLeft(4);
        deque.insertLeft(4);
        System.out.println(deque.insertRight(3));
        System.out.println(deque.insertLeft(5));
        System.out.println(deque);
    }
}
