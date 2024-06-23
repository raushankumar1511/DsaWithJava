package com.stackqueue.Questions;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxINSlidingWindow  {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        int ri = 0;
        for (int i = 0; i < n; i++) {
             //remove numbers when out of range k
            if(!q.isEmpty() && q.peek() == i-k){
                q.poll();
            }
            // also remove the smaller numbers in k range as they are use less
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i>=k-1){
                ans[ri++] = nums[q.peek()];
            }
        }
        return ans;
    }
}
