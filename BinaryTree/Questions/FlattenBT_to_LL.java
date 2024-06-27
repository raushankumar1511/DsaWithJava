package BinaryTree.Questions;


public class FlattenBT_to_LL {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null){
            if(curr.left != null){
                TreeNode temp = curr.left;
                while (temp.right != null){
                    temp = temp.right;
                }
                temp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    TreeNode prev = null;
    public void flatten2(TreeNode root) {
       if(root == null)return;
       if(root.right != null) {
           flatten(root.right);
       }
       if(root.left != null){
           flatten(root.left);
       }
       root.right = prev;
       root.left = null;
       prev = root;
    }
}
