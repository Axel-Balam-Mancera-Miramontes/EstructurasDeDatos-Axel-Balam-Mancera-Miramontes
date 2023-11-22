package utils.dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class Balanced23Tree<T extends Comparable<T>> {

    private Node<T> root;

    /**
     * Constructs an empty Balanced23Tree.
     */
    public Balanced23Tree() {
        this.root = null;
    }

    /**
     * Inserts a value into the tree.
     *
     * @param value The value to be inserted.
     */
    public void insert(T value) {
        System.out.println("***" + value);
        if (root == null) {
            root = new Node<>(value);
        } else {
            root = insert(root, value);
        }
    }

    private Node<T> insert(Node<T> node, T value) {
        System.out.println(value);
        if (node == null) {
            return new Node<>(value);
        }

        if (node.value2 == null) {
            if (value.compareTo(node.value1) < 0) {
                node.value2 = node.value1;
                node.value1 = value;
            } else {
                node.value2 = value;
            }
        }

        else {
            if (value.compareTo(node.value1) < 0) {
                Node<T> newLeft = insert(node.left, value);
                return splitNode(newLeft, node.value1, node, null);
            } else if (value.compareTo(node.value2) < 0) {
                Node<T> newMiddle = insert(node.middle, value);
                return splitNode(node.left, node.value1, newMiddle, node.value2);
            } else {
                Node<T> newRight = insert(node.right, value);
                return splitNode(node, null, newRight, value);
            }
        }

        return node;
    }

    private Node<T> splitNode(Node<T> left, T value1, Node<T> middle, T value2) {
        Node<T> newRoot = new Node<>(value1);
        newRoot.left = left;
        newRoot.middle = middle;
        newRoot.right = new Node<>(value2);

        return newRoot;
    }

    /**
     * Searches for a value in the tree.
     *
     * @param value The value to search for.
     * @return true if the value is found, false otherwise.
     */
    public boolean search(T value) {
        return search(root, value);
    }

    private boolean search(Node<T> node, T value) {
        if (node == null) {
            return false;
        }

        if (node.value1.equals(value) || (node.value2 != null && node.value2.equals(value))) {
            return true;
        }

        if (value.compareTo(node.value1) < 0) {
            return search(node.left, value);
        } else if (node.value2 == null || value.compareTo(node.value2) < 0) {
            return search(node.middle, value);
        } else {
            return search(node.right, value);
        }
    }

    /**
     * Prints the elements of the tree in level order.
     */
    public void printLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> tempNode = queue.poll();
            System.out.print(tempNode.value1 + " ");
            if (tempNode.value2 != null) {
                System.out.print(tempNode.value2 + " ");
            }

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.middle != null) {
                queue.add(tempNode.middle);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
