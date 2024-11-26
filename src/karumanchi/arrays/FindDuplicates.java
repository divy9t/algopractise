package karumanchi.arrays;

public class FindDuplicates {

    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
        findDuplicates(arr);
    }

    private static Integer findDuplicates(int[] arr) {
        if (arr.length <= 1) return arr[0];

        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        System.out.println("slow: " + slow + " fast: " + fast);

        slow = arr[0];

        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        System.out.println("slow: " + slow + " fast: " + fast);
        return slow;


    }
}
