package karumanchi.arrays;

public class MinSwapsForContiousArray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 3};

        int k = 3;

        performLogic(arr, k);
    }

    private static void performLogic(int[] arr, int k) {
        int count = 0;
        for (int j : arr) {
            if (j <= k) {
                count += 1;
            }

        }

        int bad = 0;
        for (int i = 0; i < count; i ++ ) {
            if (arr[i] > k) {
                bad++;
            }
        }

        int minSwaps = bad;
        for (int i=0, j=count; j < arr.length; j++, i++) {

            if (arr[i] > k) {
                bad--;
            }

            if (arr[j] > k){
                bad++;
            }


            minSwaps = Math.min(bad, minSwaps);
        }

        System.out.println(minSwaps);

    }


}
