package com.stackqueue.Implementation.Queue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue(5);
        queue.insert(7);
        queue.insert(9);
        queue.insert(2);
        queue.insert(12);
        queue.insert(6);


        queue.display();
        System.out.println(queue.remove());
        queue.display();

        queue.insert(55);
        System.out.println(queue.front());
        queue.display();
    }
}
