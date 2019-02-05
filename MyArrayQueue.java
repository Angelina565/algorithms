package lesson3;

import java.util.NoSuchElementException;

public class MyArrayQueue<Item> {
    Object [] queue = new Object[1];
    private int size = 0;
    private int start = 0;
    private int end = 0;

    public int getSize() {
        return size;
    }

    private void resize (int capacity) {
        Object [] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[(start+i) % queue.length];
        }
        queue = temp;
        start = 0;
        end = size;
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public void enqueue (Item item) {
        if (size == queue.length) {
            resize(2*queue.length);
        }

        queue[end++] = item;
        end = end % queue.length;
        size++;
    }

    public Item peekFront () {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (Item) queue[start];
    }

    public Item dequeue () {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Item item = (Item) queue[start];
        size--;
        start++;
        start = start % queue.length;
        if (size == queue.length/4 && size>0) {
            resize(queue.length/2);
        }
        return item;
    }

    public String toString () {
        String s = "";
        for (int i = 0; i <size ; i++) {
            s = s + queue[(start + i) % queue.length];
        }
        return s;
    }

}
