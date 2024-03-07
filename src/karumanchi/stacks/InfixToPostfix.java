package karumanchi.stacks;

import karumanchi.Utils;

public class InfixToPostfix {

    public static void main(String[] args) {
        String infix = "a*(b+c)-d/e";
        System.out.println(infixToPostfix(infix));
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
                while (!Utils.leftParenthesisStringList.contains(stackStringImplementation.peek(node))) {
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
