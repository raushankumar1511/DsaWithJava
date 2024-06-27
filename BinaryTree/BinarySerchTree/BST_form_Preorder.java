package BinaryTree.BinarySerchTree;

public class BST_form_Preorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bulidTree(preorder, new int[]{0}, Integer.MAX_VALUE);
    }

    private TreeNode bulidTree(int[] preorder, int[] i, int ub) {
        if(i[0] == preorder.length || preorder[i[0]] > ub){
            return null;
        }

        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = bulidTree(preorder , i, root.val);
        root.right = bulidTree(preorder , i , ub);

        return root;
    }
}
