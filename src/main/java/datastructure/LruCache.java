package datastructure;

import java.util.*;

public class LruCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    Node head = null, tail = null;
    int capacity = 10;
    HashMap<Integer, Node> map = new HashMap<>();

    /**
     * Moving existing reference to head position
     *
     * @param node
     */
    public void setHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null)
            head.prev = node;

        head = node;

        if (tail == null)
            head = tail;
    }

    public void deleteNode(Node node) {
        if (node.prev != null)
            node.prev.next = node.next;
        else {
            head = node.next;
        }

        if (node.next != null)
            node.next.prev = node.prev;
        else
            tail = node.prev;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.value = value;
            deleteNode(temp);
            setHead(temp);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() > capacity) {
                map.remove(tail.key);
                deleteNode(tail);
            }
            setHead(newNode);
            map.put(key, newNode);

        }
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            deleteNode(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }

}
