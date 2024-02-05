package easy;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1}, 0));
        System.out.println(searchInsert(new int[]{1,3}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));

    }

    public static int searchInsert(int[] nums, int target) {
        int p = 0;
        int q = nums.length;

        while (p <= q && p < nums.length) {
            int middle = (p + q) /2;

            if (nums[middle] == target)
                return middle;
            else if (nums[middle] < target)
                p = middle + 1;
            else
                q = middle - 1;

        }
        return p;

    }
}
