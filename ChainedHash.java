import java.util.LinkedList;

public class chainedHash {

    private LinkedList<KeyValue>[] table;
    private int m;

    public chainedHash(int m) {

        this.m = m;
        table = new LinkedList[m + 1];

        for (int i = 1; i <= m; i++)
            table[i] = new LinkedList<>();
    }

    // Same hash function
    public int hash(String key) {
        int h = Math.abs(key.hashCode());
        return (h % m) + 1;
    }

    // Insert
    public void insert(String key, String value) {

        int i = hash(key);

        for (KeyValue kv : table[i]) {
            if (kv.key.equals(key)) {
                kv.value = value;
                return;
            }
        }

        table[i].add(new KeyValue(key, value));
    }

    // Lookup
    public String lookup(String key) {

        int i = hash(key);

        for (KeyValue kv : table[i]) {
            if (kv.key.equals(key))
                return kv.value;
        }

        return null;
    }

    // Remove
    public String remove(String key) {

        int i = hash(key);

        for (KeyValue kv : table[i]) {

            if (kv.key.equals(key)) {

                table[i].remove(kv);
                return kv.value;
            }
        }

        return null;
    }

    public boolean isInTable(String key) {
        return lookup(key) != null;
    }

    public boolean isEmpty() {

        for (int i = 1; i <= m; i++)
            if (!table[i].isEmpty())
                return false;

        return true;
    }
              }
