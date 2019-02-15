package lesson6;

import java.util.Random;

public class Program6 {
    public static void main(String[] args) {
        final int SIZE = 20;
        BST<Integer, Integer> []tree = new BST[SIZE];
        int count = 0;
        int perc = 0;
        for (int i = 0; i < SIZE ; i++) {
            tree[i] = new BST<>();
            while (tree[i].height()<6) {
                int rnd = -100 + new Random().nextInt(200);
                tree[i].put(rnd, 1);
            }
            System.out.println(tree[i].isBalanced());
            System.out.println("Размер " + i + " дерева = " +tree[i].size());
            System.out.println("");
            if (tree[i].isBalanced()) {
                count++;
            }

        }
        perc = 100- count/SIZE*100;
        System.out.println("Процент несбалансированных деревьев: " + perc);
    }
}
