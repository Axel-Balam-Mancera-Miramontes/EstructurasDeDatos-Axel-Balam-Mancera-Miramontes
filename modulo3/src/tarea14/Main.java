/**
 * @author Axel Balam Mancera Miramontes
 */

package tarea14;

import utils.graphs.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        // Insert values into the tree
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        // Perform in-order traversal and print values
        System.out.println("In-Order Traversal:");
        tree.inOrderTraversal();

        // Search for a value in the tree
        int valueToSearch = 40;
        System.out.println("Is " + valueToSearch + " in the tree? " + tree.search(valueToSearch));

        // Delete a value from the tree
        int valueToDelete = 30;
        tree.delete(valueToDelete);

        // Perform in-order traversal after deletion
        System.out.println("In-Order Traversal after deleting " + valueToDelete + ":");
        tree.inOrderTraversal();
    }
}
