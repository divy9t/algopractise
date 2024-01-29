package easy.sortedSquare;

public class LongestPrefix {
    public static void main(String[] args) {
        System.out.println(findLongestPrefix(new String[]{"flower","flow","fligs"}));
    }

    private static String findLongestPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        for (int i=0; i < strs[0].length(); i++){
            char comp = strs[0].charAt(i);
            boolean isCompCommons = true;
            for (String string : strs){
                if (string.length() <= i) {
                    isCompCommons = false;
                    break;
                }

                if (string.charAt(i) != comp) {
                    isCompCommons = false;
                    break;
                }
            }
            if (!isCompCommons)
                break;
            else
                result.append(comp);

        }
        return result.toString();
    }
}
