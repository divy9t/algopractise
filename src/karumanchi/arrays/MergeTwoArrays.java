package karumanchi.arrays;

public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        merge(arr1, arr2);
    }

    private static void merge(int[] arr1, int[] arr2) {
        int[] newArray = new int[arr2.length + arr1.length];

        int p = 0;
        int q = 0;
        int arrayPosition = 0;

        while ( p < arr1.length && q < arr2.length) {
           if (arr1[p] < arr2[q]) {
               newArray[arrayPosition++] = arr1[p];
               p++;
           } else {
               newArray[arrayPosition++] = arr2[q];
               q++;
           }
        }

        while (p < arr1.length) {
            newArray[arrayPosition++] = arr1[p];
            p++;
        }

        while (q < arr2.length) {
            newArray[arrayPosition++] = arr2[q];
            q++;
        }

        for (int j : newArray) {
            System.out.print(j + " ");
        }

    }
}
