package BinaryTree.Questions;

import java.util.HashMap;
import java.util.Map;

public class BTFromINorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = bulidTree(inorder,0,inorder.length -1,postorder,0,postorder.length -1 , inMap);

        return root;
    }

    private TreeNode bulidTree(int[] inorder, int inStart, int inEnd,
                               int[] postorder, int postStart, int postEnd,
                               Map<Integer,Integer> inMap){

        if(postStart > postEnd || inStart > inEnd)return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = bulidTree(inorder,inStart,inRoot -1,
                             postorder, postStart, postStart+ numsLeft-1
                            , inMap);

        root.right = bulidTree(inorder,inRoot + 1, inEnd,
                postorder, postStart + numsLeft ,postEnd -1,inMap);

        return root;
    }
}
