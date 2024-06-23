package Linklistwhole.Questions;

public class IntersectionLinkedlist {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int l1 = 0;
        int l2= 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != null){
            l1++;
            tempA = tempA.next;
        }
         while(tempB != null){
            l2++;
            tempB = tempB.next;
        }

        if(l1 > l2){
            int diff = l1-l2;
            tempA = headA;
            while(diff != 0){
                tempA = tempA.next;
                diff--;
            }
            tempB = headB;
        }else{
            int diff = l2 - l1;
            tempB = headB;
            while(diff != 0){
                tempB = tempB.next;
                diff --;
            }
            tempA = headA;
        }

        while(tempA != null && tempB != null){
            if(tempA == tempB )return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }

        //2nd approch

        // HashMap<ListNode , ListNode> set = new HashMap<>();
        // ListNode temp = headA;
        // while(temp != null){
        //     set.put(temp,temp.next);
        //     temp = temp.next;
        // }
        // ListNode tempB = headB;
        // while(tempB!= null){
        //     if(set.containsKey(tempB)){
        //         if(tempB.next == set.get(tempB)){
        //             return tempB;
        //         }
        //     }
        //     tempB= tempB.next;
        // }
        return null;
    }
}