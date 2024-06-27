package BinaryTree.Questions;

public class SumRootToLeafNumbers {
    //1st approch
//    int sum = 0;
//    public int sumNumbers(TreeNode root) {
//        preorderSum(root,0);
//        return sum;
//
//    }
//
//    private void preorderSum(TreeNode root, int currNum) {
//        if(root == null){
//            return;
//        }
//
//        currNum = (currNum *10) + root.val;
//        if(root.left == null && root.right == null ){
//            sum = sum + currNum;
//        }
//        preorderSum(root.left,currNum);
//        preorderSum(root.right,currNum);
//    }

    //2nd better approch.
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    private int helper(TreeNode node, int sum) {
        if(node == null){
            return 0;
        }
        sum = sum*10  + node.val;
        if(node.left == null && node.right == null){
            return sum;
        }
        return helper(node.left, sum) + helper(node.right,sum);
    }
}
