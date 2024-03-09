package karumanchi.stacks;

import karumanchi.Utils;

public class InfixToPostfix {

    public static void main(String[] args) {
        String infix = "a*(b+c)-d/e";
        System.out.println(infixToPostfix(infix));
        System.out.println(infixToPrefix(infix));
    }

    private static String infixToPrefix(String infix) {
        String reversedString = reverseString(infix);

        StringBuilder stringBuilder = new StringBuilder();
        StringNode node = new StringNode();
        StackStringImplementation stackStringImplementation = new StackStringImplementation();

        for (int i = 0; i<reversedString.length(); i++) {
            char character = reversedString.charAt(i);
            if (Character.isLetterOrDigit(character)) {
                stringBuilder.append(character);
            }

            else if (Utils.leftParenthesisList.contains(character))
            {
                while (node != null && !Utils.rightParenthesisStringList.contains(stackStringImplementation.peek(node))) {
                    stringBuilder.append(stackStringImplementation.peek(node));
                    node = stackStringImplementation.pop(node);
                }
                node = stackStringImplementation.pop(node);
            }
            else if (Utils.rightParenthesisList.contains(character))
                node = stackStringImplementation.push(character, node);

            else {
                while (!stackStringImplementation.isEmpty(node) && Utils.getPrecedence(String.valueOf(character)) <= Utils.getPrecedence(stackStringImplementation.peek(node))) {
                    stringBuilder.append(stackStringImplementation.peek(node));
                    node = stackStringImplementation.pop(node);
                }
                node = stackStringImplementation.push(character, node);

            }
        }

        while (!stackStringImplementation.isEmpty(node)) {
            stringBuilder.append(stackStringImplementation.peek(node));
            node = stackStringImplementation.pop(node);
        }

        return stringBuilder.reverse().toString();
    }

    private static String reverseString(String infix) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = infix.length() - 1; i >= 0; i--) {
            stringBuilder.append(infix.charAt(i));
        }

        return stringBuilder.toString();
    }

    private static String infixToPostfix(String infix) {
        StringBuilder stringBuilder = new StringBuilder();
        StringNode node = new StringNode();
        StackStringImplementation stackStringImplementation = new StackStringImplementation();

        for (int i = 0; i<infix.length(); i++) {
            char character = infix.charAt(i);
            if (Character.isLetterOrDigit(character)) {
                stringBuilder.append(character);
            }

             else if (Utils.leftParenthesisList.contains(character))
                node = stackStringImplementation.push(character, node);

            else if (Utils.rightParenthesisList.contains(character)) {
                while (node != null && !Utils.leftParenthesisStringList.contains(stackStringImplementation.peek(node))) {
                    stringBuilder.append(stackStringImplementation.peek(node));
                    node = stackStringImplementation.pop(node);
                }
                node = stackStringImplementation.pop(node);
            }

            else {
                while (!stackStringImplementation.isEmpty(node) && Utils.getPrecedence(String.valueOf(character)) <= Utils.getPrecedence(stackStringImplementation.peek(node))) {
                    stringBuilder.append(stackStringImplementation.peek(node));
                    node = stackStringImplementation.pop(node);
                }
                node = stackStringImplementation.push(character, node);

            }
        }

        while (!stackStringImplementation.isEmpty(node)) {
            stringBuilder.append(stackStringImplementation.peek(node));
            node = stackStringImplementation.pop(node);
        }
        return stringBuilder.toString();
    }

}
