package LeetCodeDailyQuestions;

public class LinkedListInABinaryTreeO70924 {

//    Definition for singly-linked list.
    public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
//      Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    private boolean dfs(TreeNode root, ListNode head){

        if(head == null)return true;

        if(root == null) return false;

        if(root.val == head.val){
            return (dfs(root.left, head.next) || dfs(root.right, head.next));
        }
        return false;

    }
    public boolean isSubPath(ListNode head, TreeNode root) {

        if(root == null)return false;

        if(head.val == root.val){

            if(dfs(root.left , head.next))return true;

            else if(dfs( root.right, head.next)) return true;
        }

        return isSubPath(head,root.left) == true ? true : isSubPath(head, root.right);
    }
}
