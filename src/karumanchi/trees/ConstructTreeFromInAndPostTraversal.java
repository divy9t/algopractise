package karumanchi.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInAndPostTraversal {
    int currentPostOrderIndex = 0;

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};


        TreeNode root = new ConstructTreeFromInAndPostTraversal().buildTree(inorder, postorder);



        System.out.println(root.toString());


    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        currentPostOrderIndex = postorder.length - 1;
        Map<Integer, Integer> inOrderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, postorder, 0 , inorder.length - 1, inOrderMap);

    }
    public TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, Map<Integer, Integer> inOrderMap) {
        if (inStart > inEnd) {
            return null;
        }

        int currentRoot = postorder[currentPostOrderIndex--];
        TreeNode node = new TreeNode(currentRoot);

        Integer currentRootIndex = inOrderMap.get(currentRoot);

        node.right = buildTreeHelper(inorder, postorder, currentRootIndex + 1, inEnd, inOrderMap);
        node.left = buildTreeHelper(inorder, postorder, inStart, currentRootIndex - 1, inOrderMap);


        return node;

    }

}
