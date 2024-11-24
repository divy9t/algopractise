package karumanchi.arrays;

public class CyclicArrayRotation {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void rotateArray(int[] arr) {

        if (arr.length == 0) {
            return;
        }

        int temp = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i  -1];
        }


        arr[0] =  temp;


    }
}
