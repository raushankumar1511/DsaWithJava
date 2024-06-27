package BinaryTree.Questions;

public class BTMaxiPathSum {
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
           maxPathDown(root);
           return maxi;
    }

    private int maxPathDown(TreeNode node) {
        if(node == null){
            return 0;
        }
        int leftSum = Math.max(0,maxPathDown(node.left));
        int rightSum = Math.max(0, maxPathDown(node.right));

        maxi = Math.max(maxi,(leftSum+rightSum+node.val));

        return node.val+ Math.max(leftSum,rightSum);
    }
}
