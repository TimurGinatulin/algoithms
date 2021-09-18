package lesson8;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer,String> list = new HashMapList<>(5);
        list.put(10,"one");
        list.put(20,"Two");
        list.put(30,"one");
        list.put(40,"Two");
        list.put(50,"one");
        list.put(60,"Two");
        list.display();
        int si = 0;
        System.out.println(si==0);
    }
}
