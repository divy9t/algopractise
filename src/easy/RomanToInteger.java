package easy;

import java.util.HashMap;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInteger("XLVIII"));
    }

    private static Integer romanToInteger(String value) {
        HashMap<Character, Integer> romanIntValue = new HashMap<>() {{
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int numberValue = 0;
        int previousNumberValue = 0;

        for (int i = value.length() - 1; i >= 0; i--){
            Integer integerValue = romanIntValue.get(value.charAt(i));
            if (integerValue >= previousNumberValue)
                numberValue += integerValue;
            else
                numberValue -= integerValue;
            previousNumberValue = integerValue;
        }

        return numberValue;

    }


}
