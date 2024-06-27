package BinaryTree.Implementation;

import com.sun.source.tree.Tree;

import java.util.*;

public class BFS {
    // iterative method
    public static List<List<Integer>> levelOrdrer(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                if(q.peek().left != null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right != null){
                    q.offer(q.peek().right);
                }
                subList.add(q.poll().val);
            }
            ans.add(subList);
        }
        return ans;
    }

    //recursive method
//    public static List<List<Integer>> levelOrdrer(TreeNode root){
//
//        List<List<Integer>> ans = new ArrayList<>();
//        if(root == null){
//            return ans;
//        }
//        helper(root,0,ans);
//        return ans;
//    }
//
//    private static void helper(TreeNode root, int level , List<List<Integer>> ans) {
//        if(root == null)return;
//        if(level ==  ans.size()){
//            ans.add(new ArrayList<>());
//        }
//        ans.get(level).add(root.val);
//        helper(root.left,level+1, ans);
//        helper(root.right, level+1, ans);
//    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        System.out.println("level order Traversal" + levelOrdrer(root));
    }
}
