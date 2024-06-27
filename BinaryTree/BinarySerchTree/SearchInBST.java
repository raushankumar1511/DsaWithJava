package BinaryTree.BinarySerchTree;

public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {

        while(root != null && root.val != val ){
            root = val < root.val ? root.left: root.right;
        }
        return root;
        // while(root != null){
        //     if(root.val == val ){
        //         return root;
        //     }
        //     else if(val < root.val){
        //         root = root.left;
        //     }
        //     else{
        //         root = root.right;
        //     }
        // }
        // return null;
    }
}
