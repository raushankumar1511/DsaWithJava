package Linklistwhole.Questions;

public class AddTwoNUM {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 ==null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode ansHead = new ListNode();
        ListNode temp = ansHead;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(digit);
            temp.next = node;
            temp = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int sum = l1.val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(digit);
            temp.next = node;
            temp = node;
            l1 = l1.next;
        }
        while (l2 != null){
            int sum = l2.val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(digit);
            temp.next = node;
            temp = node;
            l2 = l2.next;
        }
        if(carry == 1 ){
            ListNode node = new ListNode(carry);
            temp.next = node;
        }
        ListNode result = ansHead.next;
        ListNode dummynode = ansHead;
        dummynode.next = null;
        return result;
    }

}
