package datastructure;

public class Queue <T extends Comparable<T>>{
    class Node<T> {
        T value;
        Node<T> next;
        public Node(T value) {
            this.value = value;
        }
    }

    Node<T> head, tail;

    public void offer(T value){
        Node<T> node = new Node<>(value);
        if(head == null && tail == null){
            head = tail = node;
        }
        else{
            tail.next = node;
            tail = tail.next;
        }
    }

    public T poll() {
        if (head == null && tail == null)
            return null;
        else {
           T value = head.value;
           head = head.next;
           return value;
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
