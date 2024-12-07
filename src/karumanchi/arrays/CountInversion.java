package karumanchi.arrays;

public class CountInversion {

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(countInversion(arr));
    }

    /**
     * Counts the number of inversions in the array using a modified merge sort algorithm.
     * An inversion is a pair of indices (i, j) such that i < j and arr[i] > arr[j].
     *
     * @param arr the input array
     * @return the number of inversions in the array
     */
    private static int countInversion(int[] arr) {
        // Call the recursive merge sort and count function
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }


    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;

        if ( left < right ) {
            int mid = (left + right) / 2;

            count += mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid + 1, right);

            count += mergeAndCount(arr, left, mid, right);
        }

        return count;
    }

    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        // Create temporary arrays for the left and right halves
        int[] leftArr = java.util.Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = java.util.Arrays.copyOfRange(arr, mid + 1, right + 1);


        int i = 0, j = 0, k = left, swaps = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];

            } else {
                arr[k++] = rightArr[j++];
                swaps += (mid + 1) - (left + i);
            }
        }

        // Copy any remaining elements of leftArr
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        // Copy any remaining elements of rightArr
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

        return swaps;
    }


}