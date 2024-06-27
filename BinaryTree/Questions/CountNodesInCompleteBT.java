package BinaryTree.Questions;

class CountNodesInCompleteBT {
    //O(n) solution
    // public int countNodes(TreeNode root) {
    //     if(root == null)return 0;

    //     return countNodes(root.left) + countNodes(root.right) +1;
    // }

    //O((log n)^2) solution
    //space complexity O(log n)
    public int countNodes(TreeNode root) {
        if(root == null)return 0;

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        if(lh == rh) return (int)Math.pow(2,lh) -1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    int leftHeight(TreeNode node){
        int height =0;
        while(node != null)
        {
            height++;
            node=node.left;
        }
        return height;
    }
    int rightHeight(TreeNode node){
        int height =0;
        while(node != null)
        {
            height++;
            node=node.right;
        }
        return height;
    }
}