package karumanchi;

import java.util.Arrays;

public class arrays_tuf {
    public static void main(String[] args) {
        System.out.println(new arrays_tuf().arraySortedOrNot(new int[]{48,81,17}, 3));

    }

    boolean arraySortedOrNot(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }

        return true;

    }

    public void reverse(int[] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[n - i - 1];
            arr[n - i - 1] = arr[i];
            arr[i] = temp;

        }

    }

    public int sum(int arr[], int n) {
        int sum = 0;
        while (n > 0) {
            sum += arr[n - 1];
            n--;
        }
        return sum;
    }

    public int countOdd(int[] arr, int n) {
        int odd = 0;

        while (n > 0) {
            if (arr[n - 1] % 2 != 0) odd++;
            n--;
        }
        return odd;

    }
}

