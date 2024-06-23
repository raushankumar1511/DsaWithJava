package Linklistwhole.Questions;


public class ReverseKGroup {

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<= 1 || head == null ){
            return head;
        }
        ListNode temp = head;
        int count=0;
        while(temp!= null){
            count++;
            temp= temp.next;
        }
        int times = count/k;
        ListNode prev = null ;
        ListNode curr = head;

        while (times>0) {

            ListNode last = prev;
            ListNode reversedEnd = curr;

            //reverse the part left to right
            ListNode next = curr.next;

            for (int i = 1; curr != null && i <= k; i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            reversedEnd.next = curr;
            prev = reversedEnd;
            times--;
        }
        return head;
    }


    //2nd method to reverse k groups
    public ListNode reverseKGroup2(ListNode head , int k){
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null){
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null){
                if(prevNode != null){
                    prevNode.next= temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseList(temp);
            if(temp == head){
                head = kthNode;
            }else{
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    private ListNode findKthNode(ListNode temp, int k) {
        k -=1;
        while(temp != null && k> 0){
            k--;
            temp = temp.next;
        }
         return temp;
    }
    public ListNode reverseList(ListNode head){
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
