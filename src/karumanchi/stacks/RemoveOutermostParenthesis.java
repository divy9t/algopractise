package karumanchi.stacks;


import java.util.HashMap;
import java.util.Stack;

/**
 * Input: s = "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 */
public class RemoveOutermostParenthesis {
    /*
    It is really simple first push elements to stack
    then if the closing parenthesis is encountered then pop element from stack
    add the popped elements to a new list
     */

    public static void main(String[] args) {

//        System.out.println(new RemoveOutermostParenthesis().removeOuterParentheses("(()())(())"));
        System.out.println(new RemoveOutermostParenthesis().removeOuterParentheses("(()())(())(()(()))"));

    }


    // the same problem can also be solved using queues where they follow the fifo structure
    // to keep the sequencing
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        HashMap<String, Character> closingMap = new HashMap<>();
        closingMap.put(")",'(');
        closingMap.put("(",')');

        Character startChar = '(';

        int start = 0, close = 0;

        for ( Character c : s.toCharArray()) {
            if ((start == 0 || close == 0) || start != close) {
                if (startChar.equals(c))
                    start++;
                else
                    close++;
                stack.push(String.valueOf(c));
            } else {
                if (stack.isEmpty()) {
                    start = 1;
                    close = 0;
                    stack.push(String.valueOf(c));
                    continue;
                }
                stack.pop();
                while (!stack.isEmpty()) {
                    String top = stack.pop();
                    if (stack.isEmpty()) {
                        start = 1;
                        close = 0;
                        stack.push(String.valueOf(c));
                        break;
                    }
                    result.append(closingMap.getOrDefault(top,'n'));
                }
            }

        }


        // removing the top stack
        stack.pop();
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (stack.isEmpty())
                break;

            result.append(closingMap.getOrDefault(top,'n'));
        }

        return result.toString();
    }
}
