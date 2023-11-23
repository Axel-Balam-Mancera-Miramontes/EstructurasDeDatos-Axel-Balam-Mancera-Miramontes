package utils.collection;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A basic implementation of a generic HashMap.
 * @param <Key> The type of keys.
 * @param <Value> The type of values.
 */
public class HashMap<Key, Value> {
    private static final int INITIAL_CAPACITY = 16;
    private ArrayList<LinkedList<Entry<Key, Value>>> buckets;
    private int size;

    /**
     * Constructs a new HashMap with the specified initial capacity.
     */
    public HashMap() {
        buckets = new ArrayList<>(INITIAL_CAPACITY);
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets.add(new LinkedList<>());
        }
        size = 0;
    }

    private int calculateIndex(Key key) {
        int hash = key.hashCode();
        return Math.abs(hash) % buckets.size();
    }

    /**
     * Associates the specified value with the specified key in this map.
     * @param key The key with which the specified value is to be associated.
     * @param value The value to be associated with the specified key.
     */
    public void add(Key key, Value value) {
        int index = calculateIndex(key);
        LinkedList<Entry<Key, Value>> bucket = buckets.get(index);

        for (Entry<Key, Value> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;
    }

    /**
     * Returns the value to which the specified key is mapped in this map, or null if this map contains no mapping for the key.
     * @param key The key whose associated value is to be returned.
     * @return The value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    public Value get(Key key) {
        int index = calculateIndex(key);
        LinkedList<Entry<Key, Value>> bucket = buckets.get(index);

        for (Entry<Key, Value> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    /**
     * Returns a list of keys in the HashMap.
     * @return A list of keys in the HashMap.
     */
    public ArrayList<Key> getKeys() {
        ArrayList<Key> outputValues = new ArrayList<>();

        for (LinkedList<Entry<Key, Value>> bucket : buckets) {
            for (Entry<Key, Value> entry : bucket) {
                outputValues.add(entry.getKey());
            }
        }

        return outputValues;
    }

    /**
     * Returns a list of values in the HashMap.
     * @return A list of values in the HashMap.
     */
    public ArrayList<Value> getValues() {
        ArrayList<Value> outputValues = new ArrayList<>();

        for (LinkedList<Entry<Key, Value>> bucket : buckets) {
            for (Entry<Key, Value> entry : bucket) {
                outputValues.add(entry.getValue());
            }
        }

        return outputValues;
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     * @param key The key to check for.
     * @return True if this map contains a mapping for the specified key, false otherwise.
     */
    public boolean containsKey(Key key) {
        int index = calculateIndex(key);
        LinkedList<Entry<Key, Value>> bucket = buckets.get(index);

        for (Entry<Key, Value> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     * @param key The key whose mapping is to be removed from the map.
     */
    public void remove(Key key) {
        int index = calculateIndex(key);
        LinkedList<Entry<Key, Value>> bucket = buckets.get(index);
        Entry<Key, Value> toRemove = null;

        for (Entry<Key, Value> entry : bucket) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }
        if (toRemove != null) {
            bucket.remove(toRemove);
            size--;
        }
    }

    /**
     * Returns the number of key-value mappings in this map.
     * @return The number of key-value mappings in this map.
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether the hashmap is empty or not.
     * @return whether the hashmap is empty or not.
     */
    public boolean isEmpty() {
        return (size() > 0) ? false : true;
    }

    /**
     * Removes all of the mappings from this map.
     */
    public void clear() {
        for (LinkedList<Entry<Key, Value>> bucket : buckets) {
            bucket.clear();
        }
        size = 0;
    }
}
