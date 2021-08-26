public class Deq<E> {
    private E[] data;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public Deq(int size) {
        this.data = (E[]) new Object[size];
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public void display() {
        System.out.println(this);
    }


    public boolean insertLeft(E value) {
        if (isFull())
            return false;
        if (tail == 0) {
            E[] buffer = (E[]) new Object[data.length];
            buffer[0] = value;
            for (int i = tail; i < head; i++) {
                buffer[i + 1] = data[i];
            }
            data = buffer;
            head++;
        } else {
            data[--tail] = value;
        }
        size++;
        return true;
    }


    public boolean insertRight(E value) {
        if (isFull())
            return false;
        data[head] = value;
        head++;
        size++;
        return true;
    }


    public E removeLeft() {
        size--;
        return data[tail++];
    }


    public E removeRight() {
        size--;
        return data[head--];
    }


    public String toString() {
        if (tail == -1)
            tail = 0;
        StringBuilder sb = new StringBuilder("--->[");
        for (int i = tail; i < head; i++) {
            sb.append(data[i]);
            if (i != head - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

