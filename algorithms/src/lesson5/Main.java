package lesson5;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> list = new LinkedList<>();
        System.out.println(sqrt(2,2));
        list.add(new Object("kiwi", 1, 3));
        list.add(new Object("apple", 2, 2));
        list.add(new Object("mango", 2, 4));
        list.add(new Object("mango2", 2, 4));
        ObjectHandler handler = new ObjectHandler();
        handler.findBestSets(list, 6);
    }

    public static long sqrt(long num, long deg) {
        deg--;
        if (deg == 0)
            return num;
        return num * sqrt(num, deg);
    }
}
