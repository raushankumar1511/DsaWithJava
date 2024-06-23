package Linklistwhole.Questions;

public class LinklistCycle1 {
    ListNode head;
    static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public static void main(String[] args) {
       LinklistCycle1 list = new LinklistCycle1();
       ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        list.head = one;
        one.next = two;
        two.next=three;
        three.next= four;
        four.next= five;
        five.next = two;

        System.out.println(cycleLength(one));

    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    public static int cycleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                do{
                    slow=slow.next;
                    count++;
                }while (fast!=slow);
                return count;
            }
        }
        return 0;
    }
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
//if fast  and slow is equal then cycle present
            if(fast == slow){
                // find the length of cycle
                do{
                    slow=slow.next;
                    length++;
                }while (fast!=slow);
                break;
            }
        }

        //move the one node by length of cycle times
        ListNode f= head;
        ListNode s = head;

        while (length > 0){
            s= s.next;
            length--;
        }

        //keep moving both forward and they will meet at cycle start
        while (f != s) {
            f=f.next;
            s= s.next;
        }
        return f;
    }
}