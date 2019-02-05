package lesson3;

import java.util.NoSuchElementException;

public class MyArrayDeque<Item> {
    Object [] deque = new Object[1];
    private int size = 0;
    private int start = 0;

    public int getSize() {
        return size;
    }

    public void insertRight (Item item) {
        if (size == deque.length) {
            resize(2*deque.length);
        }
        deque[size] = item;
        size++;
    }

    public void insertLeft (Item item) {
        if (size == deque.length) {
            resize(2*deque.length);
        }
        Object [] temp = new Object[size+1];

        for (int i = 0; i < size; i++) {

            temp[i+1] = deque[i];
        }
        deque = temp;
        deque[start] = item;
        size++;
    }

    public boolean isEmpty () {
        return (size == 0);
    }

    public Item revomeLeft () {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = (Item) deque[start];
        start++;
        size--;
        start = start % deque.length;
        if (size == deque.length/4 && size>0) {
            resize(deque.length/2);
        }
        return item;
    }

    public Item removeRight () {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = (Item) deque[size-1];
        size--;
        if (size == deque.length/4 && size>0) {
            resize(deque.length/2);
        }
        return item;
    }

    private void resize (int capacity) {
        Object [] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = deque[(start+i)%deque.length];
        }
        deque = temp;
        start = 0;
    }

    public String toString () {
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + deque[i] + ", ";
        }
        return s;
    }

}
