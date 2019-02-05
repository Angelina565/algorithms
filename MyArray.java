package lesson2;

public class MyArray<Item extends Comparable<Item>> {

    Object [] arr = new Object[1];
    int size = 0;

    public Item get (int index) {
        if (index < 0 || index > size-1) {
            throw new IndexOutOfBoundsException();
        }
        return (Item) arr[index];
    }

    public void set (int index, Item item) {
        if (index < 0 || index > size-1) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = item;
    }

    public void insert (Item item) {
        if (size == arr.length) {
            resize(2 * arr.length);
        }
        arr[size] = item;
        size++;
    }

    private void resize (int capacity) {
        Object []temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public boolean find (Item item) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean delete (Item item) {
        int i = 0;
        while (i < size && !arr[i].equals(item)) {
            i++;
        }

        if (i == size) {
            return false;
        }

        for (int j = i; j < size - 1; j++) {
            arr[j] = arr[i + 1];
        }
        arr[size-1] = null;
        size--;

        if (size == arr.length/4 && size > 0) {
            resize(arr.length/2);
        }
        return true;
    }

    private boolean less (Item item1, Item item2) {
        return item1.compareTo(item2) < 0;
    }


    private void change (int i, int j) {
        Item temp = (Item) arr[i];
        arr [i] = arr[j];
        arr[j] = temp;
    }

    public void sortSelection () {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less((Item) arr[j], (Item) arr[min])) {
                    min = j;
                }
                change(i, min);
            }
        }

    }

    public void sortInsertion () {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0 ; j--) {
                if (less((Item) arr[j], (Item) arr[j-1])) {
                    change(j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public void sortBubble () {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less((Item)arr[j+1],(Item) arr[j])) {
                    change(j, j+1);
                }
                
            }
        }
    }

}
