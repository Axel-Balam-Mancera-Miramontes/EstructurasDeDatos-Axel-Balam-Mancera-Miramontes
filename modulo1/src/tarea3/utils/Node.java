/**
 * @author Axel Balam Mancera Miramontes
 */


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
