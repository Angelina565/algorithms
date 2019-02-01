package lesson2;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int size = 100000;
        MyArray<Integer> arr = new MyArray<>();
        for (int i = 0; i < size ; i++) {
            arr.insert(new Random().nextInt(50));
        }
        arr.insert(45);
        arr.insert(23);
        System.out.println(arr.size);
        System.out.println(arr.find(4));
        System.out.println(arr.delete(3));
        System.out.println(arr.size);
//        arr.sortSelection();
        arr.sortInsertion();
//        arr.sortBubble();
        long time = System.currentTimeMillis() - startTime;
        System.out.println(time);
    }

}
