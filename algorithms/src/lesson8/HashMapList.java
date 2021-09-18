package lesson8;

import java.util.ArrayList;
import java.util.List;

public class HashMapList<K, V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {

        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }

    private final List<Item<K, V>>[] data;

    private int size;

    public HashMapList(int initialCapacity) {
        this.data = new ArrayList[initialCapacity * 2];
        for (int i = 0; i < data.length; i++) {
            data[i] = new ArrayList<>();
        }
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }
        int index = hashFunc(key);
        if (!isEmpty()) {
            for (Item i : data[index]) {
                if (i.getKey().equals(key)) {
                    data[index].remove(i);
                    size--;
                    break;
                }
            }
        }
        data[index].add(new Item<>(key, value));
        size++;
        return true;
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        for (Item i : data[index]) {
            if (i.getKey().equals(key))
                return (V) i.getValue();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        Item<K, V> tempItem;
        for (Item i : data[index]) {
            if (i.getKey().equals(key)) {
                tempItem = i;
                if (data[index].remove(i))
                    return tempItem.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("---------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
        }
        System.out.println("---------------");
    }
}