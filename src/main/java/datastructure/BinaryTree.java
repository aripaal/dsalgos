package datastructure;

import java.util.*;

public class BinaryTree<T extends Comparable<T>> {
    Node root = null;

    final class Node<T> {
        T value = null;
        Node<T> left = null, right = null;

        Node(T value) {
            this.value = value;
        }
    }

    /**
     * Adding New nodes
     */
    public void add(T v) {
        if (root == null) {
            root = new Node(v);

        } else {
            add(v, root);
        }
    }

    private void add(T v, Node<T> cursor) {
        //less
        if (v.compareTo(cursor.value) < 0) {
            if (cursor.left == null) {
                cursor.left = new Node<>(v);
            } else {
                add(v, cursor.left);
            }
        }
        //greater
        else {
            if (cursor.right == null) {
                cursor.right = new Node<>(v);
            } else {
                add(v, cursor.right);
            }
        }
    }

    /**
     * Recursive traversals using a List for viewing
     * in UTs
     */
    public void preOrder(List<T> view) {
        if (root == null)
            return;
        preOrder(view, root);
    }

    private void preOrder(List<T> view, Node<T> cursor) {
        if (cursor == null)
            return;
        view.add(cursor.value);
        preOrder(view, cursor.left);
        preOrder(view, cursor.right);
    }

    public void inOrder(List<T> view) {
        if (root == null)
            return;
        inOrder(view, root);
    }

    private void inOrder(List<T> view, Node<T> cursor) {
        if (cursor == null)
            return;
        inOrder(view, cursor.left);
        view.add(cursor.value);
        inOrder(view, cursor.right);
    }
    public void postOrder(List<T> view) {
        if (root == null)
            return;
        postOrder(view, root);
    }

    private void postOrder(List<T> view, Node<T> cursor) {
        if (cursor == null)
            return;
        postOrder(view, cursor.left);
        view.add(cursor.value);
        postOrder(view, cursor.right);
    }

    /**
     * Dimensions of Binary Tree
     * @return
     */
    public int calcSize() {
        return calcSize(root);
    }

    private int calcSize(Node node) {
        if (node == null)
            return 0;
        //leaf node
        if (node.left == null && node.right == null)
            return 1;
        //non-leaf node
        return 1 + calcSize(node.left) + calcSize(node.right);
    }
    //Return 1 + max height of either left subtree or right subtree
    public int height(){
        return height(root);
    }
    public int height(Node cursor){
        if(cursor == null)
            return 0;

        return 1+ Math.max(height(cursor.left),height(cursor.right));
    }
}
