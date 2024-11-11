package karumanchi.arrays;

public class FindHighLowNumber {

    public static void main(String[] args) {
        int[] arr = {11, 13, 23, 12, 5};
        findHighLowNumber(arr);
    }

    private static void findHighLowNumber(int[] arr) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i : arr) {
            if (low > i)
                low = i;

            if (high < i)
                high = i;
        }

        System.out.println("Lowest Number: " + low);
        System.out.println("Highest Number: " + high);
    }
}
