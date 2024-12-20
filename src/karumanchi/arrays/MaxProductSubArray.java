package karumanchi.arrays;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 0, 2};
        maxProductSubArray(arr);
    }

    private static void maxProductSubArray(int[] arr) {
        int maxProduct = arr[0];
        int minProduct = arr[0];
        int productSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(arr[i], arr[i] * maxProduct);
            minProduct = Math.min(arr[i], arr[i] * minProduct);

            productSoFar = Math.max(maxProduct, productSoFar);
        }

        System.out.println(productSoFar);

    }
}
