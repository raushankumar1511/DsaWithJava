package BinaryTree.BinarySerchTree;

import java.util.Stack;

class BSTIterator2 {
    Stack<TreeNode> stack = new Stack<>();
    boolean reverse = true;

    public BSTIterator2(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        if(reverse){
            pushAll(node.left);
        }else {
            pushAll(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
    private void pushAll(TreeNode node){
        while (node != null){
            stack.push( node);
            if(reverse){
                node = node.right;
            }else {
                node = node.left;
            }
        }
    }
}
public class TwoSumInBST {
    public boolean findTarget(TreeNode root, int k){
        if(root== null )return false;
        BSTIterator2 l = new BSTIterator2(root, false);
        BSTIterator2 r = new BSTIterator2(root, true);

        int i = l.next();
        int j = r.next();
        while (i< j){
            if(i+j == k)return true;
            else if (i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}
