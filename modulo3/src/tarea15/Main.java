package tarea15;

import utils.dataStructures.Balanced23Tree;

public class Main {
    public static void main(String[] args) {
        Balanced23Tree<Integer> tree = new Balanced23Tree<>();

        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);

        System.out.println("Tree after insertion:");
        tree.printLevelOrder();

        System.out.println("\nIs 4 present in the tree? " + tree.search(4));
        System.out.println("Is 6 present in the tree? " + tree.search(6));
    }
}
