package Linklistwhole.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromeList {
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
    public static void main(String[] args) {

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next= node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(isPalindrome3(node1));


    }

    public static boolean isPalindrome3(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!= null){
            list.add(head.val);
            head = head.next;
        }

        int s = 0;
        int e = list.size()-1;
        while (s <  e && list.get(s) == list.get(e)) {
            s++;e--;
        }
        return s >= e;
    }
// using stack
    public static boolean isPalindrome2(ListNode head) {
        ListNode middle = getMidNode(head);
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = middle;

        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        while (!stack.isEmpty()){
            ListNode top = stack.pop();
            System.out.println(top.val);
            if(head.val != top.val){
                return false;
            }
            head= head.next;
        }
        return true;
    }
    //using reverse;
    public static boolean isPalindrome(ListNode head) {
           ListNode middle = getMidNode(head);
           ListNode reverseHead = reverseList(middle);
           ListNode rereverseList = reverseHead;

           while (head != null && reverseHead != null){
               if(head.val != reverseHead.val){
                   break;
               }
               head = head.next;
               reverseHead = reverseHead.next;
           }
           reverseList(rereverseList);

           return head == null || reverseHead == null  ;
    }

    public static ListNode reverseList(ListNode head){
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
    public static ListNode getMidNode(ListNode head){
        ListNode f = head;
        ListNode s = head;
        while(s != null && s.next!= null){
            f = f.next;
            s = s.next.next;
        }
        return f;
    }
}
