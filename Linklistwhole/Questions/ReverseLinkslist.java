package Linklistwhole.Questions;

public class ReverseLinkslist {
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
//recursively
    public ListNode reverseList(ListNode head){
        if(head.next== null ){
            return  head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // iteratively
    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;

        while (pres != null){
            pres.next = prev;
            prev = pres;
            pres = next ;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }

    // reverse the part of linked list from left position to right position
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode prev = null ;
        ListNode curr = head;

        for(int i = 1; curr!= null && i<=left-1 ; i++){
            prev = curr;
            curr = curr.next;
        }
        ListNode last = prev;
        ListNode reversedEnd = curr;

        //reverse the part left to right
        ListNode next = curr.next;
        for(int i = left ; curr != null && i<= right ; i++){
            curr.next = prev;
            prev= curr;
            curr = next;
            if(next!= null){
                next = next.next;
            }
        }

        if(last  != null){
            last.next = prev;
        }else{
            head = prev;
        }

        reversedEnd.next = curr;
        return head;
    }
}
