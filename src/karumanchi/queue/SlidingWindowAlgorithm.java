package karumanchi.queue;

public class SlidingWindowAlgorithm {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 11, 6, 7, 8, 9};
        maxSumInSlidingWindowUsingCircularQueue(arr, 3);
    }

    private static void maxSumInSlidingWindowUsingCircularQueue(int[] arr, int windowSize) {
        int sum = 0;
        CircularQueueImplementation queue = new CircularQueueImplementation(5);

        for ( int i=0; i < windowSize; i++ ) {
            queue.enqueue(arr[i]);
            sum += arr[i];
        }

        int maxSum = sum;

        for (int i = windowSize; i < arr.length; i++ ) {
            int dequeue = queue.dequeue();
            queue.enqueue(arr[i]);
            sum = sum - dequeue + arr[i];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println("The max sum is: " +  maxSum);
    }


}
