package com.stackqueue.Questions;

import java.util.Stack;

public class NextGreaterElement {
    // this for only in strictly right
    public int[] nextGreaterElement(int[] nums1) {
        int n = nums1.length;
        Stack<Integer> st = new Stack<>();
        int[] nge =new int[n];
        for (int i = n-1; i >=0 ; i--) {
            while (st.isEmpty() == false && st.peek() <= nums1[i]){
                st.pop();
            }
            int nextGE = (st.isEmpty())?(-1):st.peek();
            nge[i] = nextGE;
            st.push(nums1[i]);
        }
        return nge;
    }
    // serach next greater element in circular fashion
    public int[] nextGreaterElemen2(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nge =new int[n];
        for (int i = 2 * n-1; i >=0 ; i--) {
            while (st.isEmpty() == false && st.peek() <= nums[i% n]){
                st.pop();
            }
            if(i < n) {
                int nextGE = (st.isEmpty()) ? (-1) : st.peek();
                nge[i] = nextGE;
            }
            st.push(nums[i% n]);
        }
        return nge;
    }
}
