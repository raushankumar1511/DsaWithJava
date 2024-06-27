package BinaryTree.BinarySerchTree;

public class RecoverBST {
    private TreeNode first,middle, last, prev;

    private void inorder(TreeNode root){
        if(root == null)return;

        inorder(root.left);
        if(prev != null && (root.val < prev.val)){
            // this is first violation , mark these as first and middle
            if(first == null) {
                first = prev;
                middle = root;
            }
            // this is second violation , mark this node as last
            else {
                last = root;
            }
        }
        // mark this as previous
        prev = root;
        inorder( root.right);
    }
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if(first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}
