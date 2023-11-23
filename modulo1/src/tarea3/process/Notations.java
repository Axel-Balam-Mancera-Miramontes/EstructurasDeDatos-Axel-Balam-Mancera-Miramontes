/**
 * @author Axel Balam Mancera Miramontes
 */


package tarea3.process;

import tarea3.utils.Pila;

public class Notations {
    /**
     * Converts a given input string into a stack of substrings.
     *
     * @param str The input string to be converted.
     * @return A stack of substrings parsed from the input string.
     */
    public static Pila<String> strToStack(String str) {
        Pila<String> stack = new Pila<>();
        StringBuilder currentSubstring = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
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

    /**
     * Converts a given input string representing a mathematical infix expression into its postfix expression equivalent.
     *
     * @param infix The mathematical infix expression.
     * @return The mathematical postfix representation of the input expression.
     */
    public static String strInfixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Pila<Character> stack = new Pila<>();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek().get() != '(') {
                    postfix.append(stack.pop().get());
                }
                stack.pop().get(); // Pop the '('
            } else {
                while (!stack.isEmpty() && precedence(stack.peek().get()) >= precedence(c)) {
                    postfix.append(stack.pop().get());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop().get());
        }

        return postfix.toString();
    }

    /**
     * Converts a given input stack representing a mathematical infix expression into its postfix expression equivalent.
     *
     * @param infix The mathematical infix expression.
     * @return The mathematical postfix representation of the input expression.
     */
    public static Pila<String> stackInfixToPostfix(Pila<String> infix) {
        Pila<Character> stack = new Pila<>();
        Pila<String> postfix = new Pila<>();

        while (!infix.isEmpty()) {
            String element = infix.pop().get();
            char c = element.charAt(0);

            if (Character.isDigit(c)) {
                postfix.push(element);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek().get() != '(') {
                    postfix.push(String.valueOf(stack.pop().get()));
                }
                stack.pop(); // Pop the '('
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

    private static double performOperation(double operand1, double operand2, String operator) {
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
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    /**
     * Calculates the resulting answer of evaluating the given postfix expression.
     *
     * @param stackExpression The mathematical postfix expression.
     * @return The result of evaluating the given postfix expression.
     */
    public static double evaluatePostfixExpression(Pila<String> stackExpression) {
        Pila<Double> ans = new Pila<>();

        while (!stackExpression.isEmpty()) {
            String element = stackExpression.pop().get();
            if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                double operand2 = ans.pop().get();
                double operand1 = ans.pop().get();
                double result = performOperation(operand2, operand1, element);
                ans.push(result);
            } else {
                ans.push(Double.parseDouble(element));
            }
        }

        return ans.pop().get();
    }

}
