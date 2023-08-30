package tarea3.process;

import tarea3.utils.Pila;

public class Notations {
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

    public static String strInfixToPostfix(String infix){
        Pila<Character> stack = new Pila<>();
        String postfix = "";

        for (char c : infix.toCharArray()) {
            if (c >= '0' && c <= '9') {
                postfix += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek().get() != '(') {
                    postfix += stack.pop().get();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek().get()) >= precedence(c)) {
                    postfix += stack.pop().get();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop().get();
        }

        return postfix;
    }

    public static Pila<String> stackInfixToPostfix(Pila<String> infix){
        Pila<Character> stack = new Pila<>();
        Pila<String> postfix = new Pila<>();

        while (!infix.isEmpty()) {
            String element = infix.pop().get();

            char c = element.charAt(0);
            if (c >= '0' && c <= '9') {
                postfix.push(element);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek().get() != '(') {
                    postfix.push(String.valueOf(stack.pop().get()));
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek().get()) >= precedence(c)) {
                    postfix.push(String.valueOf(stack.pop().get()));
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.push(String.valueOf(stack.pop().get()));
        }

        postfix = postfix.inverse();
        return postfix;
    }

    public static Pila<String> strToStack(String str) {
        Pila<String> stack = new Pila<>();
        StringBuilder currentSubstring = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                currentSubstring.append(ch);
            } else {
                if (currentSubstring.length() > 0) {
                    stack.push(currentSubstring.toString());
                    currentSubstring.setLength(0);
                }
                stack.push(String.valueOf(ch));
            }
        }

        if (currentSubstring.length() > 0) {
            stack.push(currentSubstring.toString());
        }

        return stack;
    }

    private static int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int evaluatePostfixExpression(Pila<String> stackExpression){
        Pila<Integer> ans = new Pila<>();

        //Recorrer expresión postfija como pila
        while (!stackExpression.isEmpty()) {
            String element = stackExpression.pop().get();
            System.out.println("Numero = " + element);
            if (element.equals("+") || element.equals("-") ||
                element.equals("*") || element.equals("/")) {
                int operand2 = ans.pop().get();
                int operand1 = ans.pop().get();
                int result = performOperation(operand1, operand2, element);
                ans.push(result);
            } else {
                ans.push(Integer.parseInt(element));
            }
        }

        return ans.pop().get();
    }

}
