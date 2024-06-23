package Linklistwhole.Questions;

public class RemoveNthLastNode {
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
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//
//           ListNode temp = head;
//           int len = 0;
//           while (temp != null){
//               len ++;
//               temp = temp.next;
//           }
//
//           if(len ==1)return null;
//           int prev = len - n;
//           temp = head;
//
//           int i =1;
//           while(i <= prev -1){
//               temp = temp.next;
//               i++;
//           }
//           ListNode toRemove = temp.next;
//           temp.next = temp.next.next;
//           toRemove.next = null;
//
//           return head;
//    }
public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null)return null;
    ListNode ptr1 = head;
    ListNode ptr2 = head;

    int i =1;
    while(i <= n){
        ptr2  = ptr2.next;
        i++;
    }
    if(ptr2 == null){
        return head.next;
    }
    while(ptr2.next != null){
        ptr1 = ptr1.next;
        ptr2 = ptr2.next;
    }
    ptr1.next = ptr1.next.next;
    return head;
}
}
