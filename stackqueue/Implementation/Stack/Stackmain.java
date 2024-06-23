package com.stackqueue.Implementation.Stack;

public class Stackmain {
    public static void main(String[] args){
        CustomStack stack = new DynamicStack(5);
        stack.push(5);
        stack.push(6);
        stack.push(23);
        stack.push(8);
        stack.push(7);
        stack.push(98);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
