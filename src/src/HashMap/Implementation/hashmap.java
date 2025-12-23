package HashMap.Implementation;
import java.util.*;

class MyHashMap<K, V> {

    private static final int SIZE = 1000;
    private LinkedList<Pair<K, V>>[] table;

    // Simple Pair class (since Java doesn't have std::pair)
    private static class Pair<K, V> {
        K key;
        V value;
        Pair(K k, V v) {
            key = k;
            value = v;
        }
    }

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // Put key-value pair (replace if key exists)
    public void put(K key, V value) {
        int idx = hashFunc(key);
        for (Pair<K, V> p : table[idx]) {
            if (p.key.equals(key)) {
                p.value = value;
                return;
            }
        }
        table[idx].add(new Pair<>(key, value));
    }

    // Get value associated with key (null if not found)
    public V get(K key) {
        int idx = hashFunc(key);
        for (Pair<K, V> p : table[idx]) {
            if (p.key.equals(key)) {
                return p.value;
            }
        }
        return null;
    }

    // Check if key exists
    public boolean containsKey(K key) {
        int idx = hashFunc(key);
        for (Pair<K, V> p : table[idx]) {
            if (p.key.equals(key)) return true;
        }
        return false;
    }

    // Return all keys
    public List<K> keySet() {
        List<K> keys = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            for (Pair<K, V> p : table[i]) {
                keys.add(p.key);
            }
        }
        return keys;
    }

    // Main function for testing
    public static void main(String[] args) {

        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        if (map.containsKey("two")) {
            System.out.println("two -> " + map.get("two"));
        }

        map.put("two", 22);
        System.out.println("two -> " + map.get("two"));

        System.out.print("Keys: ");
        for (String key : map.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
}

