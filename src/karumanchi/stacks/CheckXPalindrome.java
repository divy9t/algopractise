package karumanchi.stacks;

import java.util.Objects;

public class CheckXPalindrome {

    public static void main(String[] args) {
        System.out.println(isStringPalindromeUsingStack(new String[]{"a","b","X","b","a"}));
        System.out.println(isStringPalindromeUsingTwoPointers(new String[]{"a","b","X","b","a"}));

    }

    private static boolean isStringPalindromeUsingTwoPointers(String[] strings) {
        int p = 0;
        int q = strings.length - 1;

        while (p < strings.length ) {
            if (p == q && !Objects.equals(strings[p], "X"))
                return false;
            if (p == q)
                break;
            if (Objects.equals(strings[p], strings[q])) {
                p++;
                q--;
            }

        }
        return true;
    }

    private static boolean isStringPalindromeUsingStack(String[] strings) {
        StringNode node = new StringNode();
        StackStringImplementation stackStringImplementation = new StackStringImplementation();
        boolean startPopping=false;

        for (String s : strings) {
            if (s.equals("X")){
                startPopping = true;
                continue;
            }
            if (startPopping) {
                if (node.val == s) node = stackStringImplementation.pop(node);
                else return false;
            } else {
                node = stackStringImplementation.push(s, node);
            }

        }
        return stackStringImplementation.isEmpty(node);


    }
}
