/**
 * @author Axel Balam Mancera Miramontes.
 */

package utils.dataStructures;

public class Node<T> {

    /**
     * Values stored in the node.
     */
    T value1;
    T value2;

    /**
     * References to the children nodes.
     */
    Node<T> left;
    Node<T> middle;
    Node<T> right;

    /**
     * Constructs a node with one value and no children.
     *
     * @param value1 The first value to be stored in the node.
     */
    Node(T value1) {
        this.value1 = value1;
        this.value2 = null;
        this.left = this.middle = this.right = null;
    }

    /**
     * Constructs a node with two values and no children.
     *
     * @param value1 The first value to be stored in the node.
     * @param value2 The second value to be stored in the node.
     */
    Node(T value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
        this.left = this.middle = this.right = null;
    }
}
