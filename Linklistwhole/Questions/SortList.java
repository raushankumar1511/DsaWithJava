package Linklistwhole.Questions;

import java.util.List;

public class SortList {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
         return merge(left,right);

    }

    public  ListNode merge(ListNode list1, ListNode list2) {
        ListNode ansHead = new ListNode();
        ListNode ansTail = ansHead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ansTail.next = list1;
                list1 = list1.next;
                ansTail = ansTail.next;
            }else{
                ansTail.next = list2;
                list2 = list2.next;
                ansTail = ansTail.next;
            }
        }
        if(list1 != null){
            ansTail.next = list1;
        }
        if(list2 != null){
            ansTail.next = list2;
        }
        return ansHead.next;
    }

    ListNode getMid ( ListNode head){
        ListNode midPrev = null;
        while(head != null && head.next != null){
            midPrev = (midPrev == null) ? head: midPrev.next;
            head = head.next.next;
        }

        ListNode mid = midPrev.next;
        midPrev.next= null;
        return mid;
    }
}
