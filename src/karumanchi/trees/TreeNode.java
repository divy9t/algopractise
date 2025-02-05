package karumanchi.trees;

import lombok.ToString;

@ToString
public class TreeNode {
    public int val;
    public int horizontalDistance;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof TreeNode) {
            TreeNode other = (TreeNode) obj;
            return this.val == other.val &&
                    (this.left == null ? other.left == null : this.left.equals(other.left)) &&
                    (this.right == null ? other.right == null : this.right.equals(other.right));
        }
        return false;
    }
}
