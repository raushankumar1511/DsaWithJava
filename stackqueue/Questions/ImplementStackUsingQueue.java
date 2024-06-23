package com.stackqueue.Questions;

import com.stackqueue.Implementation.Queue.InbuiltQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public ImplementStackUsingQueue(){
        q1= new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    public void push(int x){
        if(q1.isEmpty()){
            q1.offer(x);
        }else{
            while (!q1.isEmpty()){
                q2.offer(q1.poll());
            }
            q1.offer(x);
            while (!q2.isEmpty()){
                q1.offer(q2.poll());
            }
        }
    }
    //push using only one queue;
    public void push2(int x){
            q1.offer(x);
           for(int i=0;i<q1.size()-1;i++){
               q1.offer(q1.poll());
           }
    }
    public int pop(){
        return q1.poll();
    }
    public int top(){
        return q1.peek();
    }
    public boolean empty(){
        return q1.isEmpty();
    }
}
