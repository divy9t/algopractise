package karumanchi.arrays;

public class RearrangeArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -1, 4};
        rearrangeArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void rearrangeArray(int[] arr) {
        int p = 0, q = 1;

        while (p < q && q < arr.length) {

            if (p % 2 == 0 && arr[p] < 0) {
                if (arr[q] > 0) {
                    rotateArray(arr, p, q);
                    p+=2;
                }
                q += 1;
            } else if (shouldSwapForNegativeIndex(arr, p)) {
                if (arr[q] < 0) {
                    rotateArray(arr, p, q);
                    p+=2;
                } q += 1;
            }
            else {
                p++;
                if (q <= p) {
                    q = p + 1; // Ensure q is always ahead of p
                }
            }


        }


    }

    private static boolean shouldSwapForNegativeIndex(int[] arr, int p) {
        return p % 2 != 0 && arr[p] > 0;
    }

    private static void rotateArray(int[] arr, int startIndex, int endIndex) {
        int temp = arr[endIndex];
        for (int i = endIndex; i > startIndex; i-- ) {
            arr[i] = arr[i-1];
        }
        arr[startIndex] = temp;

    }
}



/*
First Mistake --  Not to consider positive cases
Second Mistake -- Just thinking of swapping the numbers but not rotating the array
 */