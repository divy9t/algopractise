package karumanchi.heap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    // Constructor
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // true = access-order
        this.capacity = capacity;
    }

    // Override removeEldestEntry to evict the oldest entry when the cache exceeds capacity
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity; // Remove the eldest if the size exceeds the capacity
    }
}

 class LRUCacheExample {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3); // Cache with capacity 3

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println("Cache after adding 3 elements: " + cache);

        cache.get(1); // Access element with key 1
        cache.put(4, "D"); // Add another element, which will evict the least recently used (key 2)
        System.out.println("Cache after accessing 1 and adding 4: " + cache);

        cache.put(5, "E"); // Add another element, which will evict the least recently used (key 3)
        System.out.println("Cache after adding 5: " + cache);
    }
}
