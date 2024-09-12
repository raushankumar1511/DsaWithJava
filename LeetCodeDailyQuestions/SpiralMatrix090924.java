package LeetCodeDailyQuestions;
import java.util.*;
public class SpiralMatrix090924 {
    class ListNode {
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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for (int[] it : ans) {
            Arrays.fill(it, -1);
        }
        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                if (head == null)
                    return ans;
                ans[top][i]= (head.val);
                head = head.next;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                if (head == null)
                    return ans;
                ans[i][right] = (head.val);
                head = head.next;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    if (head == null)
                        return ans;
                    ans[bottom][i] = (head.val);
                    head = head.next;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    if (head == null)
                        return ans;
                    ans[i][left] = (head.val);
                    head = head.next;
                }
                left++;
            }

        }
        return ans;
    }
}
