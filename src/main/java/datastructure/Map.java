package datastructure;

import java.util.*;

public class Map<K, V> {
    class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    class Node {
        java.util.List<Entry<K, V>> entries = new java.util.ArrayList<Entry<K, V>>();

        Node(K key) {
            this.hash = modo(key);
        }

        int hash;
        Node next;
    }

    Node head;

    public V get(K key) {
        //head == null
        if (head == null)
            return null;
        Node cursor = head;
        while (cursor != null) {
            if (modo(key) == cursor.hash) {
                for (Entry e : cursor.entries) {
                    if (e.key.equals(key))
                        return (V) e.value;
                }
            }
            cursor = cursor.next;
        }
        return null;
    }

    public V put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);
        //If empty
        if (head == null) {
            head = new Node(key);
            head.entries.add(entry);
            return entry.value;
        }
        //If exists
        Node cursor = head;
        Node prev = null;
        while (cursor!= null) {
            if (modo(key) == cursor.hash) {
                List<Entry<K, V>> entries = cursor.entries;
                for (int i = 0; i < entries.size(); i++) {
                    if (entries.get(i).key.equals(key)) {
                        V temp = entries.get(i).value;
                        entries.set(i, entry);
                        return temp;
                    }
                }
                //None found in the entries list add it here
                entries.add(entry);
                return entry.value;
            }
            prev = cursor;
            cursor = cursor.next;
        }
        //This is a new node, as hash doesn't exist for it
        prev.next = new Node(key);
        cursor = prev.next;
        cursor.entries.add(entry);


        return entry.value;
    }

    int modo(K key) {
        return key.hashCode() % 5;
    }

}
