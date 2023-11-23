package tarea3.utils;

<<<<<<< HEAD
=======
/**
 * @author Axel Balam Mancera Miramontes
 */


>>>>>>> origin/master
package tarea3.utils;

import java.util.Optional;

public class Node <E>{
    E data;
    Optional<Node<E>> next;
    public Node(E data) {
        this.data = data;
        next = Optional.empty();
    }
}
