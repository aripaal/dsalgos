package datastructure;

public class LinkedList<T extends Comparable<T>> {
    class Node<T> {
        T value;
        Node<T> next;
        public Node(T value) {
            this.value = value;
        }
    }

    Node<T> head = null;

    public void addNode(T value) {
        Node<T> temp = new Node<>(value);
        if (head == null) {
            head = temp;
            return;
        }
        Node<T> cursor = head;
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        cursor.next = temp;
    }

    public void remove(T value) {
        Node<T> cursor = head, prev = null;

        //head has the value
        if (cursor.value == value)
            head = cursor.next;
        //head does not have the value

        while (cursor != null) {
            prev = cursor;
            cursor = cursor.next;
            if (cursor != null && cursor.value == value)
                prev.next = cursor.next;

        }

    }


    /**
     * Basic functions
     */
    public int size() {
        return size(head);
    }

    private int size(Node<T> cursor) {
        if (cursor == null)
            return 0;
        return 1 + size(cursor.next);
    }

    public String print() {
        return print(head);
    }

    private String print(Node<T> cursor) {
        if (cursor == null)
            return "null";
        return cursor.value + " -> " + print(cursor.next);
    }
}
