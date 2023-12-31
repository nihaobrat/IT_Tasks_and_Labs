import java.util.ArrayList;
import java.util.LinkedList;


public class HashTable<K, V> {
    
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int size;

    public HashTable(int capacity) {
        table = new ArrayList<>(capacity);
        
        for (int i = 0; i < capacity; i++) {
            table.add(new LinkedList<>());
        }        
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.size();
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(index);
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(index);
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(index);
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        hashTable.put("Один", 1);
        hashTable.put("Два", 2);
        hashTable.put("Три", 3);
        
        System.out.println("Размер: " + hashTable.size()); 
        
        System.out.println("Получаем 'Два': " + hashTable.get("Два")); 

        hashTable.remove("Два");

        System.out.println("Получаем 'Два' после удаления: " + hashTable.get("Два")); 
        
        System.out.println("Размер после удаления: " + hashTable.size()); 
    }   
}