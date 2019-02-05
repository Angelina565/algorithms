package lesson3;

public class Program {
    public static void main(String[] args) {
        MyArrayStack <Character> myStack = new MyArrayStack<>();
        String s = "Hello, world";
//        преобразуем строку в набор символом и вносим их в стек
        for (int i = 0; i <s.length() ; i++) {
            char ch = s.charAt(i);
            myStack.push(ch);
        }
//        извлекает элементы из стека
        for (int i = myStack.size -1; i >=0 ; i--) {
            System.out.print(myStack.pop());
        }

        System.out.println();

        MyArrayQueue <Character> queue = new MyArrayQueue<>();
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('d');
        System.out.println(queue.getSize());
        System.out.println(queue.peekFront());
        System.out.println(queue.dequeue());
        System.out.println(queue.getSize());


        MyArrayDeque <Character> deque = new MyArrayDeque<>();

        deque.insertLeft('a');
        deque.insertLeft('b');
        deque.insertLeft('c');
        System.out.println(deque.toString());
        deque.insertRight('d');
        deque.insertRight('e');
        System.out.println(deque.toString());
        deque.removeRight();
        System.out.println(deque.toString());
        deque.revomeLeft();
        System.out.println(deque.toString());

        System.out.println(deque.getSize());


    }



}
