package tarea3;

import tarea3.utils.*;

public class Main {
    public static void main(String[] args) {
        Pila<Integer> stack = new Pila<>();
        Pila<Integer> stackB = new Pila<>();

        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while(!stack.isEmpty()){
            System.out.println(stack.pop().get());
        }

        //CLI.launchApp();
    }
}
