package BinaryTree.BinarySerchTree;

import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();;
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    private void pushAll(TreeNode node){
        while (node != null){
            stack.push( node);
            node = node.left;
        }
    }
}
