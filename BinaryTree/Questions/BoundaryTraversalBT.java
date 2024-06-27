package BinaryTree.Questions;

import java.util.ArrayList;

public class BoundaryTraversalBT {
    public ArrayList<Integer> printBoundary(TreeNode node){
        ArrayList<Integer> ans = new ArrayList<>();
        if(isLeaf(node) == false ) ans.add(node.val);
        addLeftBoundary(node,ans);
        addLeaves(node,ans);
        addRightBoundary(node,ans);
        return ans;
    }

    private void addLeftBoundary(TreeNode root, ArrayList<Integer> ans) {
        TreeNode cur = root.left;
        while (cur != null){
            if(isLeaf(cur) == false){
                ans.add(cur.val);
            }
            if(cur.left != null)cur = cur.left;
            else cur= cur.right;
        }
    }
    private void addLeaves(TreeNode root, ArrayList<Integer> ans) {
        if(isLeaf(root)){
            ans.add(root.val);
            return;
        }
        if(root.left != null) addLeaves(root.left,ans);
        if(root.right != null) addLeaves(root.right ,ans);
    }
    private void addRightBoundary(TreeNode root, ArrayList<Integer> ans) {
        TreeNode cur = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (cur != null){
            if(isLeaf(cur) == false){
                temp.add(cur.val);
            }
            if(cur.right != null)cur = cur.right;
            else cur= cur.left;
        }
        for (int i = temp.size() -1 ; i >= 0 ; --i) {
            ans.add(temp.get(i));
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
