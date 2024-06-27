package BinaryTree.Questions;

public class LCAOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // if node is null or if node is p or q then also node
        if(root == null || root == p || root ==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);


        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }
        else {// if both left and right are not null we found the result;
            return root;
        }

    }
}
