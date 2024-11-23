package karumanchi.arrays;

public class MoveNegativeElementsToOneSide {
    public static void main(String[] args) {
        int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        moveNegativeElementsToOneSide(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void moveNegativeElementsToOneSide(int[] arr) {

        int p = 0;
        int q = arr.length - 1;

        while (p < q) {
            if (arr[p] < 0) {
                p++;
                continue;
            }
            if (arr[q] < 0) {
                int temp = arr[q];
                arr[q] = arr[p];
                arr[p] = temp;
                p++;
            }
            q--;

        }
    }
}
