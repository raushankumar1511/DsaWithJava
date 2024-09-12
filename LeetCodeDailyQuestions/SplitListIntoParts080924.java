package LeetCodeDailyQuestions;

import java.util.Arrays;

public class SplitListIntoParts080924 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        Arrays.fill(ans,null);

        int n = 0;
        ListNode temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        int partLength = n/k;
        int largerParts = n % k;
        int i = 0;
        ListNode current = head;
        while(i< k){
            if(current != null){
                ans[i] = current;
            }else break;

            int j = 0;
            int currPartLen = partLength;
            if(i < largerParts) ++currPartLen;
            ListNode prev = current;

            while(j < currPartLen){
                prev = current;
                current = current.next;
                j++;
            }
            prev.next = null;
            i++;
        }

        return ans;

    }
}
