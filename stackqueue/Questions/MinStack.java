package com.stackqueue.Questions;

import java.util.*;

public class MinStack {
    List<int[]> st;
    public MinStack() {
        st = new ArrayList<>();
    }
    
    public void push(int val) {
       if(!st.isEmpty()){
           int min = st.getLast()[1];
           if(val < min){
               min = val;
           }
           st.add(new int[]{val,min});
       }else{
           st.add(new int[]{val,val}) ;
       }
    }
    
    public void pop() {
       st.removeLast();
    }
    
    public int top() {
         return st.getLast()[0];
    }
    
    public int getMin() {
        return st.getLast()[1];
    }
}