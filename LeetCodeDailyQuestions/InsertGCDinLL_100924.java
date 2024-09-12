package LeetCodeDailyQuestions;

public class InsertGCDinLL_100924 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(){}
        ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null)
            return head;
        ListNode curr = head;

        while (curr.next != null) {

            int a = curr.val;
            int b = curr.next.val;
            int gcd = (a > b) ? gcd(b, a) : gcd(a, b);

            ListNode temp = curr.next;
            ListNode newNode = new ListNode(gcd);

            curr.next = newNode;
            newNode.next = temp;
            curr = temp;
        }
        return head;
    }
}
