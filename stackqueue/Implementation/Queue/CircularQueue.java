package com.stackqueue.Implementation.Queue;

public class CircularQueue {
    protected int[] data;
    private static final int default_size = 10;

    int end = 0;
    int front =0;
    int size = 0;

    public CircularQueue(){
        this(default_size);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull(){
        return size == data.length;// ptr at last index
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }
    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int removed = data[front];
        front = (front + 1) % data.length;
        size --;
        return removed;
    }
    public int front() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[front];
    }
    public void display(){
       if(isEmpty()){
           System.out.println("Empty");
           return;
       }
       int i = front;
       do{
           System.out.print(data[i] +" -> ");
           i++;
           i %= data.length;
       }while (i!= end);
        System.out.println("END");
    }
}
