package karumanchi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    private static Map<String, Integer> precedenceMap = new HashMap<>();
    public static List<Character> leftParenthesisList = new ArrayList<>();
    public static List<String> leftParenthesisStringList = new ArrayList<>();
    public static List<Character> rightParenthesisList = new ArrayList<>();

    static {
        precedenceMap.put("(", 1);
        precedenceMap.put(")", 1);
        precedenceMap.put("[", 1);
        precedenceMap.put("]", 1);
        precedenceMap.put("{", 1);
        precedenceMap.put("}", 1);
        precedenceMap.put("*", 2);
        precedenceMap.put("/", 2);
        precedenceMap.put("%", 2);
        precedenceMap.put("+", 3);
        precedenceMap.put("-", 3);

        leftParenthesisList.add('(');
        leftParenthesisList.add('{');
        leftParenthesisList.add('[');

        leftParenthesisStringList.add("(");
        leftParenthesisStringList.add("{");
        leftParenthesisStringList.add("[");

        rightParenthesisList.add(')');
        rightParenthesisList.add('}');
        rightParenthesisList.add(']');
    }
    public static Integer getPrecedence(String value) {
        return precedenceMap.getOrDefault(value, 0);
    }
}
