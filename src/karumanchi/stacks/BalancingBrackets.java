package karumanchi.stacks;

import karumanchi.linkedlist.Node;
import karumanchi.linkedlist.problems.StackImplementation;

import java.util.Arrays;
import java.util.List;

public class BalancingBrackets {

    public static void main(String[] args) {
        System.out.println(isSymbolBalanced("{[()]}"));
    }

    private static boolean isSymbolBalanced(String s) {
        StringNode stack = new StringNode();
        StackStringImplementation stackImplementation = new StackStringImplementation();

        List<String> closingSymbols = Arrays.asList(")","]","}");

        for (String i : s.split("")) {
            if (!closingSymbols.contains(i))
                stack = stackImplementation.push(i, stack);
            else
                stack = stackImplementation.pop(stack);
        }
        return stackImplementation.isEmpty(stack);
    }

}
