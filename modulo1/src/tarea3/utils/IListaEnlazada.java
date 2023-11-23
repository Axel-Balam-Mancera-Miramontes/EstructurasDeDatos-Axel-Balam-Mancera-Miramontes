package tarea3.utils;

<<<<<<< HEAD
=======
/**
 * @author Axel Balam Mancera Miramontes
 */


>>>>>>> origin/master
package tarea3.utils;
import java.util.Optional;

/**
 * Interfaz base para la implementación de listas enlazadas
 * */
public interface IListaEnlazada<E>{
    void add(E e);
    void remove(E e);
    Optional<E> get(int index);
    void update(E oldValue, E newValue);
    int getSize();
    boolean contains(E t);
}