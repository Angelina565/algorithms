package lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<Item> implements Iterable<Item>{

    @Override
    public Iterator<Item> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator <Item>{

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Item item, Node next, Node previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }


    private int size = 0;
    private Node first;
    private Node last;

    public boolean isEmpty () {
        return size==0;
    }

    public void insertFirst (Item item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst, null);
        if (isEmpty()) {
            last = first;
        } else {
            oldFirst.previous = first;
        }
        size++;
    }

    public Item deleteFirst () {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        first.previous = null;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public Item getFirst () {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    public void insertLast (Item item) {
        Node oldLast = last;
        last = new Node(item, null, oldLast);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public Item deleteLast () {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = last.item;
        Node prev = last.previous;
        last.previous = null;
        last = prev;
        size--;
        if (isEmpty()) {
            first = null;
        } else {
            last.next = null;
        }
        return item;
    }

    public Item getLast () {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    public void insert (Item item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            insertFirst(item);
            return;
        } else if (index == size) {
            insertLast(item);
            return;
        }
        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        Node newNode = new Node(item, current, current.previous);
        current.previous.next = newNode; // 0 new 1
        current.previous = newNode;
        size++;
    }

    public Item delete (Item item) {
        Node current = first;
        while (!current.item.equals(item) && current!=null) {
            current = current.next;
        }
        if (current == null) {
            return null;
        } else if (current == first) {
            return deleteFirst();
        } else if (current == last) {
            return deleteLast();
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
            current.next = null;
            current.previous = null;
            return current.item;
        }
    }

    public boolean find (Item item) {
        Node current = first;
        while (!current.item.equals(item) && current != null) {
            current = current.next;
        }
        return current != null;
    }

    public int getSize() {
        return size;
    }

    public Item get (int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node currentNode = first;
        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode.item;
    }

    public void set (Item item, int index) {
        if (index < 0 || index > size-1) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node currentNode = first;
        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        currentNode.item = item;
    }

    public String toString () {
        String s = "";
        Node current = first;
        for (int i = 0; i < size ; i++) {
            s = s + current.item + ", ";
            current = current.next;
        }
        return s;
    }
}
