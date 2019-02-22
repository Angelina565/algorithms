package lesson8;


public class LinearProbingHashTable<Key, Value> {
    private int M = 97;
    private int size = 0;
    private Object [] keys = new Object[M];
    private Object [] values = new Object[M];

    public int getSize () {
        return size;
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public int hash (Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public boolean contains (Key key) {
        return get(key) != null;
    }

    public Value get (Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть равен Null");
        }
        for (int i = hash(key); keys[i] != null ; i = (i+1)%M) {
            if (((Key)keys[i]).equals(key)) {
                return (Value) values[i];
            }
        }
        return null;
    }

    public void put (Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть равен Null");
        }
        int i;
        for (i = hash(key); keys[i] != null ; i = (i+1)%M) {
            if (((Key)keys[i]).equals(key)) {
                values[i] = value;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

}
