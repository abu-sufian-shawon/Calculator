package com.faisal.peoplentech.lecture.calculator;

import java.util.Stack;
import java.util.ArrayList;


class Calculator {
    private static final String divSign = "\u00F7";
    private static final String mulSign = "\u00D7";

    private double stacky(String[] tokens) {

        // initialize the stack and the variable
        Stack<String> stack = new Stack<String>();
        double x, y;
        String result = "";
        double get = 0;
        String choice;
        double value = 0;
        String p = "";


        // Iterating to the each character
        // int the array of the string
        for (String token : tokens) {
            // if the character is not the special character
            // ('+', '-', '*', '/')
            // then push the character to the stack
            if (!token.equals("+") && !token.equals("-") && !token.equals(mulSign) && !token.equals(divSign)) {
                stack.push(token);
                continue;
            } else {
                // else if the character is special
                // character then use the switch method to
                // perform the action
                choice = token;
            }

            switch (choice) {

                case "+":
                    x = Double.parseDouble(stack.pop());
                    y = Double.parseDouble(stack.pop());
                    value = x + y;
                    result = p + value;
                    stack.push(result);
                    break;

                case "-":
                    x = Double.parseDouble(stack.pop());
                    y = Double.parseDouble(stack.pop());
                    value = y - x;
                    result = p + value;
                    stack.push(result);
                    break;
                case mulSign:
                    x = Double.parseDouble(stack.pop());
                    y = Double.parseDouble(stack.pop());
                    value = x * y;
                    result = p + value;
                    stack.push(result);
                    break;
                case divSign:
                    x = Double.parseDouble(stack.pop());
                    y = Double.parseDouble(stack.pop());
                    value = y / x;
                    result = p + value;
                    stack.push(result);
                    break;
                default:
                    continue;
            }
        }
        return Double.parseDouble(stack.pop());
    }

    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    private int Precedence(char ch) {
        final char divSign = '\u00F7';
        final char mulSign = '\u00D7';
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case mulSign:
            case divSign:
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }


    private ArrayList<String> infixToPostfix(String exp) {
        // initializing empty String for result
        ArrayList<String> result = new ArrayList<>();

        // initializing empty stack
        Stack<Character> stack = new Stack<>();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                number.append(Character.toString(c));

                // If the scanned character is an '(',
                // push it to the stack.
            else if(c == '.')
                number.append(c);
            else if (c == '(') {
                if (number.length() > 0) {
                    result.add(number.toString());
                    number = new StringBuilder();
                }
                stack.push(c);
            }

            //  If the scanned character is an ')',
            // pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')') {
                if (number.length() > 0) {
                    result.add(number.toString());
                    number = new StringBuilder();
                }
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result.add(Character.toString(stack.pop()));

                stack.pop();
            } else // an operator is encountered
            {
                if (number.length() > 0) {
                    result.add(number.toString());
                    number = new StringBuilder();
                }
                while (!stack.isEmpty() && Precedence(c)
                        <= Precedence(stack.peek())) {

                    result.add(Character.toString(stack.pop()));
                }
                stack.push(c);
            }

        }

        if (number.length() > 0) {
            result.add(number.toString());
            number = new StringBuilder();
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return new ArrayList<String>();
            result.add(Character.toString(stack.pop()));
        }
        return result;
    }

    // Driver method
    public Double getResult(String expression) {
        ArrayList<String> list = infixToPostfix(expression);
        String[] s = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            s[i] = list.get(i);
        }

        return stacky(s);
    }
}

