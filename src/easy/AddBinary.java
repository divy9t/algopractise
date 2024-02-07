package easy;

public class AddBinary {
    public static void main(String[] args) {
//        System.out.println(addBinary("11", "1"));
        System.out.println(addBinaryOne("1110110101", "1110111011"));
//        System.out.println(addBinary("1111", "1111"));
    }

    public static String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();

        int p = a.length() - 1;
        int q = b.length() - 1;

        while (p >= 0 || q >= 0) {
            int sum = carry;
            if (p >= 0) {
                sum += Character.getNumericValue(a.charAt(p));
                p -= 1;
            }
            if (q >= 0) {
                sum += Character.getNumericValue(b.charAt(q));
                q -= 1;
            }

            if (sum > 1) {
                result.append(sum / 3);
                carry = 1;
            } else {
                result.append(sum);
                carry=0;
            }
        }
        if (carry > 0)
            result.append(carry);
        return result.reverse().toString();
    }
    public static String addBinaryOne(String a, String b) {
        int carry = 0;
        String sum = String.valueOf(Long.parseLong(a) + Long.parseLong(b));
        StringBuilder result = new StringBuilder();

        for (int i = sum.length() - 1; i >= 0; i -- ) {
            int res = carry + Character.getNumericValue(sum.charAt(i));
            if (res > 1) {
                result.append(res / 3);
                carry = 1;
            } else {
                result.append(res);
                carry=0;
            }
        }
        if (carry > 0)
            result.append(carry);
        return result.reverse().toString();
    }

}
