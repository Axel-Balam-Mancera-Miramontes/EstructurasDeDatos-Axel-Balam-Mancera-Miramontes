package tarea3.utils;

import java.util.Optional;

public class Pila <E>{
    private ListaEnlazada<E> stack;

    public Pila(){
        stack = new ListaEnlazada<>();
    }

    public void push(E elmtToPush){
        stack.addFirst(elmtToPush);
    }

    public Optional<E> peek(){
        return stack.get(0);
    }

    public Optional<E> pop(){
        Optional<E> popped = stack.get(0);
        stack.remove(popped.get());
        return popped;
    }

    public int getSize() {
        return stack.getSize();
    }

    public boolean isEmpty(){
        return !(stack.getSize() > 0);
    }

    public Pila<E> inverse() {
        Pila<E> inversed = new Pila<>();

        for(int i = 0; i < stack.getSize(); ++i){
            inversed.push(stack.get(i).get());
        }

        return inversed;
    }

    public Pila<E> alternate(Pila<E> stackB){
        Pila<E> alternated = new Pila<>();

        for(int i = 0; i < Math.max(stack.getSize(), stackB.getSize()); ++i){
            try{
                alternated.push(stackB.stack.get(stack.getSize() - i - 1).get());
            }
            catch(IndexOutOfBoundsException e){}
            try{
                alternated.push(stack.get(stack.getSize() - i - 1).get());
            }
            catch(IndexOutOfBoundsException e){}
        }

        return alternated;
    }
}
