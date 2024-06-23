package Linklistwhole.Questions;

public class RotateLisT {
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
    public ListNode rotateRight(ListNode head, int k) {
          if(k<1)
              return head;
          ListNode temp = head;
          int len = 0;
          while(temp.next != null){
              len++;
              temp= temp.next;
          }
          len++;
          temp.next = head;

          int left = len - k;
         ListNode temp2 = head;
          for(int i = 0; i<left-1){
              temp2 = temp2.next;
          }
          ListNode lastNode = temp2;
          lastNode.next=null;

          ListNode newHead = temp2.next;

          return newHead;

    }
}
