package BinaryTree.BinarySerchTree;

public class KthSmallestElement {
//    public int kthSmallest(TreeNode root, int k) {
//        int curr =0;
//         inorder(root,curr,k);
//         return val;
//    }
//int curr =0;
//int val ;
//    private void inorder(TreeNode root, int curr, int k) {
//        if(root == null)return ;
//
//        inorder(root.left ,curr,k);
//        curr++;
//        if(curr == k){
//           val = root.val;
//           return ;
//        }
//        inorder(root.right ,curr,k);
//    }


    //using morris traversal
int curr =0;
int val ;
    public int kthSmallest(TreeNode root, int k) {
        int curr =0;
        getInorder(root,k);
        return val;
    }
    public void getInorder(TreeNode root ,int k) {
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                curr++;
                if(curr == k){
                    val = root.val;
                    break ;
                }
                // Move to the right child
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    curr++;
                    if(curr == k){
                        val = root.val;
                        return ;
                    }
                    cur = cur.right;
                }
            }
        }
    }

}
