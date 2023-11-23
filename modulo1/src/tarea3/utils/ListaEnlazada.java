<<<<<<< HEAD
=======
/**
 * @author Axel Balam Mancera Miramontes
 */

>>>>>>> origin/master
package tarea3.utils;

import java.util.NoSuchElementException;
import java.util.Optional;

<<<<<<< HEAD
public class ListaEnlazada<E> implements IListaEnlazada<E> {
    private Optional<Node<E>> root;
    private int size;

    public ListaEnlazada(){
=======
/**
 * This class represents a singly linked list implementation.
 * @param <E> The type of elements stored in the linked list.
 */
public class ListaEnlazada<E> implements IListaEnlazada<E> {
    private Optional<Node<E>> root; // Represents the first node in the linked list
    private int size; // Stores the number of elements in the linked list

    /**
     * Constructs an empty linked list.
     */
    public ListaEnlazada() {
>>>>>>> origin/master
        root = Optional.empty();
        size = 0;
    }

<<<<<<< HEAD
    @Override
    public Optional<E> get(int index) {
        if(index < 0 || index >= size ){
=======
    /**
     * Retrieves the element at the specified index in the linked list.
     *
     * @param index The index of the element to retrieve.
     * @return An Optional containing the element at the given index, or an empty Optional if the index is out of bounds.
     * @throws IndexOutOfBoundsException If the index is negative or greater than or equal to the size of the list.
     */
    @Override
    public Optional<E> get(int index) {
        if (index < 0 || index >= size) {
>>>>>>> origin/master
            throw new IndexOutOfBoundsException();
        }

        int currentIndex = 0;
        Optional<Node<E>> currentNode = root;

<<<<<<< HEAD
        while(currentIndex != index){
=======
        while (currentIndex != index) {
>>>>>>> origin/master
            currentNode = currentNode.get().next;
            ++currentIndex;
        }

        return Optional.of(currentNode.get().data);
    }

<<<<<<< HEAD
=======
    /**
     * Adds an element to the end of the linked list.
     *
     * @param e The element to add.
     */
>>>>>>> origin/master
    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);

<<<<<<< HEAD
        if(root.isEmpty()){
            root = Optional.of(newNode);
        }
        else{
            Optional<Node<E>> currentNode = root;

            while(currentNode.get().next.isPresent()){
=======
        if (root.isEmpty()) {
            root = Optional.of(newNode);
        } else {
            Optional<Node<E>> currentNode = root;

            while (currentNode.get().next.isPresent()) {
>>>>>>> origin/master
                currentNode = currentNode.get().next;
            }

            currentNode.get().next = Optional.of(newNode);
        }

        increaseSize();
    }

<<<<<<< HEAD
    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);

        if(root.isEmpty()){
            root = Optional.of(newNode);
        }
        else{
=======
    /**
     * Adds an element to the beginning of the linked list.
     *
     * @param e The element to add.
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);

        if (root.isEmpty()) {
            root = Optional.of(newNode);
        } else {
>>>>>>> origin/master
            newNode.next = root;
            root = Optional.of(newNode);
        }

        increaseSize();
    }

<<<<<<< HEAD
=======
    /**
     * Updates the value of an element in the linked list.
     *
     * @param oldValue The value to be updated.
     * @param newValue The new value to replace the old value.
     * @throws NoSuchElementException If the old value is not found in the linked list.
     */
>>>>>>> origin/master
    @Override
    public void update(E oldValue, E newValue) {
        Optional<Node<E>> currentNode = root;

        while (currentNode.isPresent() && !currentNode.get().data.equals(oldValue)) {
            currentNode = currentNode.get().next;
        }

        if (currentNode.isPresent()) {
            currentNode.get().data = newValue;
        } else {
            throw new NoSuchElementException();
        }
    }

<<<<<<< HEAD
=======
    /**
     * Removes an element from the linked list.
     *
     * @param e The element to remove.
     * @throws NoSuchElementException If the element is not found in the linked list.
     */
>>>>>>> origin/master
    @Override
    public void remove(E e) {
        if (root.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (root.get().data.equals(e)) {
            root = root.get().next;
            decreaseSize();
            return;
        }

        Optional<Node<E>> currentNode = root;
        Optional<Node<E>> prevNode = Optional.empty();

        while (currentNode.isPresent()) {
            if (currentNode.get().data.equals(e)) {
                prevNode.get().next = currentNode.get().next;
                decreaseSize();
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.get().next;
        }

        throw new NoSuchElementException();
    }

<<<<<<< HEAD
=======
    /**
     * Retrieves the number of elements in the linked list.
     *
     * @return The number of elements in the linked list.
     */
>>>>>>> origin/master
    @Override
    public int getSize() {
        return size;
    }

<<<<<<< HEAD
    private void increaseSize(){
        ++size;
    }

    private void decreaseSize(){
        --size;
    }

=======
    /**
     * Increases the size of the linked list by 1.
     */
    private void increaseSize() {
        ++size;
    }

    /**
     * Decreases the size of the linked list by 1.
     */
    private void decreaseSize() {
        --size;
    }

    /**
     * Checks whether the linked list contains a specific element.
     *
     * @param t The element to check for.
     * @return True if the element is found in the linked list, otherwise false.
     */
>>>>>>> origin/master
    @Override
    public boolean contains(E t) {
        Optional<Node<E>> currentNode = root;

<<<<<<< HEAD
        while(!currentNode.get().data.equals(t) && currentNode.get().next.isPresent()){
            currentNode = currentNode.get().next;
        }

        if(currentNode.get().data.equals(t)){
            return true;
        }
        return false;

    }
}
=======
        while (!currentNode.get().data.equals(t) && currentNode.get().next.isPresent()) {
            currentNode = currentNode.get().next;
        }

        if (currentNode.get().data.equals(t)) {
            return true;
        }
        return false;
    }
}
>>>>>>> origin/master
