package com.stackqueue.Questions;

import java.util.Stack;

class QueueUsingStack {
    Stack<Integer> first;
    Stack<Integer> second;

    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        int removed = second.pop();
        while (!second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }
    
    public int peek() {
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        int top = second.peek();
        while (!second.isEmpty()){
            first.push(second.pop());
        }
        return top;
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}