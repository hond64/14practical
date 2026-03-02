//Miguel Wentzel
//4478677
//Practical 4
public class openHash {

    private KeyValue[] table;
    private int m;
    private int size;

    public openHash(int m) {
        this.m = m;
        this.table = new KeyValue[m + 1]; // index 1..m
        this.size = 0;
    }

    // Hash function
    public int hash(String key) {
        int h = Math.abs(key.hashCode());
        return (h % m) + 1;
    }

    // Insert method
    public void insert(String key, String value) {

        if (isFull()) return;

        int i = hash(key);

        while (table[i] != null && !table[i].key.equals(key)) {
            i = (i % m) + 1; // linear probing
        }

        if (table[i] == null) {
            size++;
        }

        table[i] = new KeyValue(key, value);
    }

    // Lookup method
    public String lookup(String key) {

        int i = hash(key);

        while (table[i] != null) {

            if (table[i].key.equals(key))
                return table[i].value;

            i = (i % m) + 1;
        }

        return null;
    }

    // Remove method
    public String remove(String key) {

        int i = hash(key);

        while (table[i] != null) {

            if (table[i].key.equals(key)) {
                String value = table[i].value;
                table[i] = null;
                size--;
                return value;
            }

            i = (i % m) + 1;
        }

        return null;
    }

    public boolean isInTable(String key) {
        return lookup(key) != null;
    }

    public boolean isFull() {
        return size == m;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
