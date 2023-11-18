/**
 * @author Axel Balam Mancera Miramontes
 */

package utils.graphs;

/**
 * Binary Search Tree implementation.
 *
 * @param <T> The type of values stored in the tree.
 */
public class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * Inserts a new value into the tree.
     *
     * @param value The value to be inserted.
     */
    public void add(T value) {
        root = addInSubTree(root, value);
    }

    private Node<T> addInSubTree(Node<T> root, T value) {
        if (root == null) {
            return new Node<>(value);
        }

        if (value.compareTo(root.value) < 0) {
            root.left = addInSubTree(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = addInSubTree(root.right, value);
        }

        return root;
    }

    /**
     * Deletes a value from the tree.
     *
     * @param value The value to be deleted.
     */
    public void delete(T value) {
        root = deleteOnSubtree(root, value);
    }

    private Node<T> deleteOnSubtree(Node<T> root, T value) {
        if (root == null) {
            return root;
        }

        if (value.compareTo(root.value) < 0) {
            root.left = deleteOnSubtree(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = deleteOnSubtree(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.value = findMin(root.right);
            root.right = deleteOnSubtree(root.right, root.value);
        }

        return root;
    }

    /**
     * Performs an in-order traversal of the tree and prints the values.
     */
    public void inOrderTraversal() {
        inOrderTraversalRec(root);
        System.out.println();
    }

    private void inOrderTraversalRec(Node<T> root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print(root.value + " ");
            inOrderTraversalRec(root.right);
        }
    }

    /**
     * Searches for a value in the tree.
     *
     * @param value The value to search for.
     * @return True if the value is found; otherwise, false.
     */
    public boolean search(T value) {
        return searchInSubtree(root, value);
    }

    private boolean searchInSubtree(Node<T> root, T value) {
        if (root == null) {
            return false;
        }

        if (root.value.equals(value)) {
            return true;
        }

        if (value.compareTo(root.value) < 0) {
            return searchInSubtree(root.left, value);
        } else {
            return searchInSubtree(root.right, value);
        }
    }

    private T findMin(Node<T> root) {
        T min = root.value;
        while (root.left != null) {
            min = root.left.value;
            root = root.left;
        }
        return min;
    }
}
