package BinaryTree.Questions;

import java.util.*;

class AllNodesAtDistanceKFromGivenNode {
    void markParents(TreeNode root, HashMap<TreeNode,TreeNode> parent_track){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
                TreeNode node = q.poll();
                if(node.left != null){
                    parent_track.put(node.left,node);
                    q.offer(node.left);
                }
                if(node.right != null){
                    parent_track.put(node.right,node);
                    q.offer(node.right);
                }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        HashMap<TreeNode,TreeNode> parent_track = new HashMap<>();
        markParents(root,parent_track);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target,true);
        int curr_level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if(curr_level == k){
                break;
            }
            curr_level++;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if(current.left != null && visited.get(current.left) == null){
                    queue.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    queue.offer(current.right);
                    visited.put(current.right,true);
                }
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null){
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);
        }
        return result;
    }
}