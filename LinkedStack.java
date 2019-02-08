package lesson4;

public class LinkedStack<Item> {
    private MyLinkedList<Item> stack = new MyLinkedList<>();

    public void push (Item item) {
        stack.insertFirst(item);
    }

    public Item pop () {
        return stack.deleteFirst();
    }

    public Item peek () {
        return stack.getFirst();
    }

    public int getSize () {
        return stack.getSize();
    }

    public boolean isEmpty () {
        return stack.isEmpty();
    }
}
