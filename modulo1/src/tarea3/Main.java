package tarea3;

import tarea3.ui.*;
import tarea3.utils.*;

public class Main {
    public static void main(String[] args) {
        Pila<Integer> stack = new Pila<>();
        Pila<Integer> stackB = new Pila<>();
        Pila<Integer> aux = new Pila<>();

        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stackB.push(25);
        stackB.push(35);
        stackB.push(45);

        aux = stack.alternate(stackB);

        while(!stack.isEmpty()){
            System.out.print(stack.pop().get() + " ");
        }
        System.out.println();

        while(!stackB.isEmpty()){
            System.out.print(stackB.pop().get() + " ");
        }
        System.out.println();

        while(!aux.isEmpty()){
            System.out.print(aux.pop().get() + " ");
        }
        System.out.println();

        CLI.launchApp();
    }
}
