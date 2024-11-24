package karumanchi.arrays;

public class MinimumJumpsToReachArrayEnd {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minimumJumps(arr));
    }

    private static Integer minimumJumps(int[] arr) {

        if (arr.length < 0) return -1;
        if (arr[0] <= 0) return -1;

        int jump = 0;
        int farthest = arr[0];
        int farthestIndex = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) return -1;

            farthest = Math.max(farthest, i + arr[i]);

            if ( i == farthestIndex ) {
                farthestIndex = farthest;
                jump++;

                if (farthestIndex <= i) return -1;
            }
        }
    }
}
