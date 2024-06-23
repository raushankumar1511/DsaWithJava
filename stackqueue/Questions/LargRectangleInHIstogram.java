package com.stackqueue.Questions;

import java.util.Stack;

class LargRectangleInHIstogram {
//    public int largestRectangleArea(int[] heights) {
//        int n = heights.length;
//        Stack<Integer> st = new Stack<>();
//        int[] leftSmall= new int[n];
//        int[] rightSmall= new int[n];
//
//        for (int i = 0; i < n; i++) {
//            while (!st.isEmpty() && heights[st.peek()] >= heights[i]){
//                st.pop();
//            }
//            if(st.isEmpty()){
//                leftSmall[i]= 0;
//            }else {
//                leftSmall[i] = st.peek()+1;
//            }
//            st.push(i);
//        }
//
//        //empty the stack
//        while(!st.isEmpty()){
//            st.pop();
//        }
//
//        for (int i = n-1; i >= 0; i--) {
//            while (!st.isEmpty() && heights[st.peek()] >= heights[i]){
//                st.pop();
//            }
//            if(st.isEmpty()){
//                rightSmall[i]= n-1;
//            }else {
//                rightSmall[i] = st.peek() - 1;
//            }
//            st.push(i);
//        }
//        int max = 0;
//        for(int i =0; i< n; i++){
//            max = Math.max(max, heights[i] * (rightSmall[i]  - leftSmall[i] +1));
//        }
//        return max;
//    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        for (int i = 0; i <=n ; i++) {
            while (!st.isEmpty() && (i==n || heights[st.peek()] >= heights[i])){
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()){
                    width = i;
                }else {
                    width = i- st.peek() -1 ;
                }
                maxA = Math.max(maxA, height * width);
            }
            st.push(i);
        }
        return maxA;
    }
}