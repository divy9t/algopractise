package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static easy.RemoveSortedDuplicates.printLis;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{0}, 0, new int[]{1}, 1);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int r = m + n - 1;

        while (q >= 0) {
            if (p < 0) {
                nums1[r] = nums2[q];
                q--;
            }

            if (p > -1) {
                if (nums1[p] >= nums2[q]) {
                    nums1[r] = nums1[p];
                    p--;
                } else {
                    nums1[r] = nums2[q];
                    q--;
                }
            }
            r--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
