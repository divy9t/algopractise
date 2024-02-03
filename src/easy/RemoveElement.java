package easy;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int p = 0;
        int q = nums.length - 1;
        int uniqueResult = 0;

        while ( p <= q) {
            if (nums[p] == val){
                nums[p] = nums[q];
                q -= 1;
            } else {
                uniqueResult += 1;
                p += 1;
            }

        }
        return uniqueResult;
    }

}
