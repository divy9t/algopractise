package easy;

public class BstTargetSearch {
    public static void main(String[] args) {
        System.out.println(findClosestValueInBst(null, 0));
    }

    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        return -1;
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
