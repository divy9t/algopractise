package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(isValidParenthesisString("{[]}"));
    }

    private static boolean isValidParenthesisString(String s) {
        HashMap<Character, Character> parenthesisValue = new HashMap<>() {{
            put(')','(');
            put(']', '[');
            put('}', '{');
        }
        };

        if (s.length() < 2)
            return false;


        Stack<Character> symbolStack = new Stack<>();

        for (int i=0; i < s.length(); i++) {
            if (parenthesisValue.containsKey(s.charAt(i))) {
                if (symbolStack.empty() || symbolStack.pop() != parenthesisValue.get(s.charAt(i)))
                    return false;

            } else symbolStack.push(s.charAt(i));

        }
        return symbolStack.empty();
    }
}
