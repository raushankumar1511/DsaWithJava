package Linklistwhole.Questions;

public class ReorderList {
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

    public void reorderList(ListNode head) {
        if(head == null && head.next == null){
            return ;
        }
        ListNode mid = middleNode(head);

        ListNode hf = head;

        ListNode hs = reverseList(mid);

        //rearrange
        while(hf !=null && hs != null){
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        if(hf!= null){
            hf.next= null;
        }

    }

    ListNode middleNode(ListNode head){
       ListNode f = head;
       ListNode s = head;
        while(s != null && s.next!= null){
            f = f.next;
            s = s.next.next;
        }
        return f;
    }
    public ListNode reverseList (ListNode head){
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


}
