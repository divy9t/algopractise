package karumanchi.stacks;

import karumanchi.Utils;

public class FixConversions {

    public static void main(String[] args) {
        String infix = "a*(b+c)-d/e";
        System.out.println("Initial Expression: " + infix);
        System.out.println(infixToPostfix(infix));
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
        postFixToInfixManual(stringBuilder.toString());
        return stringBuilder.toString();
    }

    private static void postFixToInfixCoPilot(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        StringNode node = new StringNode();
        StackStringImplementation stackStringImplementation = new StackStringImplementation();


        for (int i = 0; i<string.length(); i++) {
            char character = string.charAt(i);
            if (Character.isLetterOrDigit(character)) {
                node = stackStringImplementation.push(character, node);
            }
            else {
                String operand1 = stackStringImplementation.peek(node);
                node = stackStringImplementation.pop(node);
                String operand2 = stackStringImplementation.peek(node);
                node = stackStringImplementation.pop(node);
                stringBuilder.append("(").append(operand2).append(character).append(operand1).append(")");
                node = stackStringImplementation.push(stringBuilder.toString(), node);
                stringBuilder = new StringBuilder();
            }
        }

        System.out.println(stringBuilder);

    }
    private static void postFixToInfixManual(String string) {
        StringNode node = new StringNode();
        StackStringImplementation stackStringImplementation = new StackStringImplementation();

        for (int i=0; i < string.length(); i++) {
            char character = string.charAt(i);

            if (Character.isLetterOrDigit(character))
                node = stackStringImplementation.push(character, node);
            else {
                String result = stackStringImplementation.peek(node);
                node = stackStringImplementation.pop(node);
                result  = "(" + result + character + stackStringImplementation.peek(node) + ")";
                node = stackStringImplementation.pop(node);
                node = stackStringImplementation.push(result, node);
            }
        }
        System.out.println(node.val);
    }

}
