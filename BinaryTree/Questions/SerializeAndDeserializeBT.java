package BinaryTree.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder res =new StringBuilder();
        while (!q.isEmpty()){
                TreeNode node = q.poll();
                if(node == null){
                    res.append("n ");
                    continue;
                }
                res.append(node.val +" ");
                q.offer(node.left);
                q.offer(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data == "")return null;

        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode parent = q.poll();
            if(!values[i].equals("n")){
                TreeNode left  = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if(!values[++i].equals("n")){
                TreeNode right  = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
