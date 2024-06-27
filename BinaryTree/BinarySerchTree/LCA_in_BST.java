package BinaryTree.BinarySerchTree;

public class LCA_in_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q){
            return root;
        }
        if(p.val < root.val && q.val < root.val){
          return  lowestCommonAncestor(root.left , p,q);
        }
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right ,p, q);
        }
        return root;
    }
}
