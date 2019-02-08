package lesson4;

import java.util.Iterator;

public class Program4 {
    public static void main(String[] args) {
        MyLinkedList <Character> list = new MyLinkedList<>();
        list.insertFirst('a');
        list.insertFirst('b');
        System.out.println(list.getSize());
        System.out.println(list.toString());
        list.insertLast('r');
        list.insert('e', 2);
        System.out.println(list.getFirst());
        System.out.println(list.getSize());
        System.out.println(list.toString());
        list.deleteFirst();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.toString());
        list.insertLast('d');
        System.out.println(list.toString());
        list.deleteLast();
        System.out.println(list.delete('r'));
        System.out.println(list.toString());
        System.out.println(list.getSize());
        list.insertLast('f');
        System.out.println(list.toString());


        Iterator<Character> iterator = list.iterator();

        while (iterator.hasNext()) {
            Character ch = iterator.next();
            System.out.println(ch);
        }

    }
}
