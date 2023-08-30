package tarea3.process;

import tarea3.utils.Pila;

public class Notations {
    public static String infixToPostfix(String infix){
        Pila<Character> stack = new Pila<>();
        String postfix = "";

        for (char c : infix.toCharArray()) {
            if (c >= '0' && c <= '9') {
                postfix += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek().get() != '(') {
                    postfix += stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek().get()) >= precedence(c)) {
                    postfix += stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    public static void evaluatePostfixExpression(){

    }
}
