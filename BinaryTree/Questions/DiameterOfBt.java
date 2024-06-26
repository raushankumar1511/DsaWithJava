package BinaryTree.Questions;
//Given the root of a binary tree, return the length of the diameter of the tree.
//
//The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
//The length of a path between two nodes is represented by the number of edges between them.
public class DiameterOfBt {
    public int diameterOfBinaryTree(TreeNode root) {

        int[] diameter = new int[1];
        height(root,diameter);
        return diameter[0];

    }
    public int height(TreeNode root ,int[] diameter) {
        if(root == null){
            return 0;
        }
        int lh = height(root.left, diameter);
        int rh = height(root.right , diameter);
        diameter[0]  = Math.max(lh+rh, diameter[0]);
        return Math.max( lh , rh)+1;
    }
}
