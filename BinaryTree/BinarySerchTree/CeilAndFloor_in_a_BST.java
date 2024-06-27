package BinaryTree.BinarySerchTree;


public class CeilAndFloor_in_a_BST {
   public int findCeil(TreeNode root, int key){
        int ceil = -1;
        while(root != null){
            if(root.val == key){
                ceil = root.val;
                return ceil;
            }
            if( key > root.val){
                root= root.right;
            }else{
                ceil = root.val;
                root= root.left;
            }
        }
        return ceil;
    }

    public int findFloor(TreeNode root, int key){
        int floor = -1;
        while(root != null){
            if(root.val == key){
                floor = root.val;
                return floor;
            }
            if( key > root.val){
                floor = root.val;
                root= root.right;
            }else{
                root= root.left;
            }
        }
        return floor;
    }
}
