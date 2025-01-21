package karumanchi.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInAndPreTraversal {
    int preIndex = 0;

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};


        TreeNode root = new ConstructTreeFromInAndPreTraversal().buildTree(preorder, inorder);



        System.out.println(root.toString());


    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        Map<Integer, Integer> inOrderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0 , inorder.length - 1, inOrderMap);


    }

    public  TreeNode buildTreeHelper(int[] preorder, int inStart, int inEnd, Map<Integer, Integer> inOrderMap) {
        if (inStart > inEnd) {
            return null;
        }

        int currentElement = preorder[preIndex++];
        TreeNode newNode = new TreeNode(currentElement);

        Integer currentIndex = inOrderMap.get(currentElement);

        newNode.left = buildTreeHelper(preorder, inStart, currentIndex - 1, inOrderMap);
        newNode.right = buildTreeHelper(preorder, currentIndex + 1, inEnd, inOrderMap);


        return newNode;

    }
}
