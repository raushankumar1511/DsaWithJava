package com.stackqueue.Implementation.Stack;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int top = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }
    //push method
    public boolean push(int item){
        if(isFull()){
            System.out.println("stack is full");
            return false;
        }
        top++;
        data[top] = item;
        return true;
    }
    //pop method
    public int pop(){
        if(isEmpty()){
            System.out.println("cannot pop from empty stack");
        }
        int removed = data[top];
        top--;
        return removed;
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("cannot peek from empty stack");
        }
        return data[top];
    }
    //size method
    public int size(){
        return top+1;
    }

    public boolean isFull() {
        return top == data.length-1;
    }
    public boolean isEmpty() {
        return top == -1;
    }

}
