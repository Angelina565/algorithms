package lesson8;

public class Program8 {
    public static void main(String[] args) {
        LinearProbingHashTable linearTable = new LinearProbingHashTable();
        linearTable.put(2, "APRICOT");
        linearTable.put(3, "KIWI");
        linearTable.put(2, "BANANA");
        linearTable.put(5, "carrot");
        linearTable.put(7,"pear");
        linearTable.put(99, "APPLE");
        System.out.println(linearTable.getSize());
        System.out.println(linearTable.get(2));
        System.out.println(linearTable.get(4));

        ChainingHashTable chain = new ChainingHashTable();
        chain.put(2, 'a');
        chain.put(4, 'b');
        chain.put(5, 'c');

        chain.put(6, 'd');
        chain.put(10, 'e');
        chain.put(12, 'f');
        chain.put(2,'g');

        System.out.println(chain.getSize());
        System.out.println(chain.get(2));


    }

}
