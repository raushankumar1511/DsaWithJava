package com.stackqueue.Implementation.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class InbuiltQueue {
    public static void main(String[] args) {
        //inbuilt queue can be implemented using two classes linked list and ArrayDequeue;
        Queue<Integer>  queue = new LinkedList<>();
//        Queue<Integer>  queue = new ArrayDeque<>();
        queue.add(5);
        queue.add(6);
        queue.add(9);
        queue.add(8);

        System.out.println(queue.poll());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue);

    }
}
