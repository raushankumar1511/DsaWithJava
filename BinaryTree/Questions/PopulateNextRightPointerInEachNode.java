package BinaryTree.Questions;

import java.util.*;

public class PopulateNextRightPointerInEachNode {
    class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right,Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public Node connect(Node root) {
        if(root == null) return root;

        Node leftMost = root;

        while (leftMost.left != null){
            Node current = leftMost;
            while (current != null){
                current.left.next = current.right;
                if(current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
//    public Node connect(Node root) {
//        if(root == null)return root;
//        Queue<Node> q = new LinkedList<>();
//        q.offer(root);
//        while (!q.isEmpty()){
//            int levelNum = q.size();
//            for (int i = 0; i < levelNum; i++) {
//                Node node = q.poll();
//                if(i<levelNum - 1){
//                    node.next = q.peek();
//                }
//                if(node.left != null){
//                    q.offer(node.left);
//                }
//                if(node.right != null){
//                    q.offer(node.right);
//                }
//            }
//        }
//        return root;
//    }

}
