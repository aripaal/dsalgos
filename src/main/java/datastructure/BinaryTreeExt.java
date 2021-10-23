package datastructure;

import java.util.*;

public class BinaryTreeExt<T extends Comparable<T>> extends BinaryTree<T> {
    /**
     * Using Queues and Stacks to traverse
     */
    @Override
    public void preOrder(List<T> view) {
        if (root == null)
            return;
        preOrder(view, root);
    }

    private void preOrder(List<T> view, Node<T> cursor) {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(cursor);
        while (!stack.isEmpty()) {
            Node<T> temp = stack.pop();
            view.add(temp.value);

            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    @Override
    public void inOrder(List<T> view) {
        if (root == null)
            return;
        inOrder(view, root);
    }

    public void inOrder(List<T> view, Node<T> cursor) {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> temp = cursor;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                view.add(temp.value);
                temp = temp.right;
            }
        }
    }

    public void levelOrder(List<T> view) {
        if (root == null)
            return;
        levelOrder(view, root);
    }

    private void levelOrder(List<T> view, Node<T> cursor) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(cursor);
        while (!queue.isEmpty()) {
            Node<T> temp = queue.poll();
            view.add(temp.value);
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
    }
}
