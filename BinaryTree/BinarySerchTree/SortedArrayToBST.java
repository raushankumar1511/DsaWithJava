package BinaryTree.BinarySerchTree;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length == 0)return null;
        TreeNode root = sortedArrayToBST(nums,0 , nums.length-1);

        return root;
    }
    private TreeNode sortedArrayToBST(int[] nums, int s, int e){
        if(e<s)return null;

        int mid = s + (e - s)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,s ,mid-1);
        root.right = sortedArrayToBST(nums,mid+1 ,e);

        return root;
    }
}
