package Linklistwhole.Questions;

public class MergeNodesInBetweenZero {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode mergeNodes(ListNode head) {

        ListNode prev = head.next;
        ListNode curr = head.next;
        head.next = null;
        head = prev;
        int sum =0;

        while(curr != null){
            if(curr.val!= 0){
                sum += curr.val;
            }else if(curr.val == 0){
                prev.val= sum;
                sum =0;
                prev.next = curr.next;
                prev = prev.next;
            }

            curr= curr.next;

        }
        return head;



    }
}
