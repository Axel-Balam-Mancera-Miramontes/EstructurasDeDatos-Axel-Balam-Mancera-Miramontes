/**
 * @author Axel Balam Mancera Miramontes
 */

package utils.graphs;

/**
 * Represents a node in a binary search tree.
 *
 * @param <T> The type of values stored in the tree.
 */
class Node<T extends Comparable<T>> {
    T value;
    Node<T> left, right;

    public Node(T item) {
        value = item;
        left = right = null;
    }
}
