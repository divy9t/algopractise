package karumanchi.stacks;

import java.io.Serializable;
import java.util.*;

public class SimplifyPath {

    public static void main(String[] args) {

        System.out.println(new SimplifyPath().simplifyPathPilot("/home/"));
        System.out.println(new SimplifyPath().simplifyPathPilot("/a//b////c/d//././/.."));
        System.out.println(new SimplifyPath().simplifyPathPilot("/a/./b/../../c/"));
        System.out.println(new SimplifyPath().simplifyPathPilot("/home/foo/.ssh/../.ssh2/authorized_keys/"));

    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Stack<String> resultStack = new Stack<>();

        List<String> exitList = Arrays.asList("..", ".");
        for (String string : path.split("/")) {
            if (!string.isEmpty())  stack.push(string);
        }
        int backCount = 1;
        while (!stack.isEmpty()) {
            String topElement = stack.pop();
            if (Objects.equals(topElement, "..")) {
                while (!stack.isEmpty() && exitList.contains(topElement)) {
                    if (stack.pop().equals(".."))backCount++;
                    if (!stack.peek().isEmpty()
                            && !exitList.contains(stack.peek())) {
                        stack.pop();
                        backCount--;
                        if (backCount == 0)  break;
                    }
                }
            } else
                resultStack.push(topElement);

           if (!stack.isEmpty() && stack.peek() != null && !exitList.contains(stack.peek()))
                    resultStack.push(stack.pop());

        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!resultStack.isEmpty()) {
            String pop = resultStack.pop();
            if (!pop.equals(".")) {
                stringBuilder.append("/");
                stringBuilder.append(pop);
            }

        }
        return stringBuilder.toString().isEmpty() ? "/" : stringBuilder.toString();
    }

    public String simplifyPathPilot(String path ) {
        Stack<String> stack = new Stack<>();
        for (String string : path.split("/")) {
            if (!string.isEmpty()) {
                if (string.equals("..")) {
                    if (!stack.isEmpty()) stack.pop();
                } else if (!string.equals(".")) {
                    stack.push(string);
                }
            }
        }
        return "/" + String.join("/", stack);
    }

}
