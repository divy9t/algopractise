package easy;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    private static int removeDuplicates(int[] nums) {
        int unique = 1;
        int trail = 0;
        int lead = 1;
        int replaceIndex = 1;

        while (trail < lead && lead < nums.length) {
            // here we move the cursor to find the next unique element
            if (nums[trail] == nums[lead]) {
                lead += 1;
            } else {
                // here we move cursor to the next unique element
                unique += 1;
                nums[replaceIndex] = nums[lead];
                trail = lead;
                lead += 1;
                replaceIndex += 1;
            }
        }
        return unique;
    }
}
