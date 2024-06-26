package BinaryTree.BinarySerchTree;

import com.sun.source.tree.Tree;

public class InsertInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root== null)return new TreeNode(val);

        TreeNode curr = root;

        while (curr!= null){
            if( val < curr.val){
                if(curr.left != null){
                    curr = curr.left;
                }else{
                    curr.left = new TreeNode(val);
                    break;
                }
            }
            if( val > curr.val){
                if(curr.right != null){
                    curr = curr.right;
                }else{
                    curr.right = new TreeNode(val);
                    break;
                }
            }

        }
        return root;
    }
}
