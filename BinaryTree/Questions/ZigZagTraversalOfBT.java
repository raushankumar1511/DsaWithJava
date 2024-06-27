package BinaryTree.Questions;

import java.util.*;
public class ZigZagTraversalOfBT {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                int index = (leftToRight) ? i: (size - 1 -i);

                if (leftToRight) {
                    row.add(node.val);
                } else {
                    row.add(0, node.val);
                }

                if(node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
//            after one level
            leftToRight = !leftToRight;
            ans.add(row);
        }
        return ans;
    }
}
