package lesson4;

public class LinkedQueue<Item> {
    private MyLinkedList<Item> queue = new MyLinkedList<>();

    public void enqueue (Item item) {
        queue.insertLast(item);
    }

    public Item dequeue () {
        return queue.deleteFirst();
    }

    public Item peekFront () {
        return queue.getFirst();
    }

    public int getSize () {
        return queue.getSize();
    }

    public boolean isEmpty () {
        return queue.isEmpty();
    }

}

