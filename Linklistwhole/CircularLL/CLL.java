package Linklistwhole.CircularLL;

import java.util.HexFormat;

public class CLL {
    private Node head;
    private Node tail;

    public CLL() {
       head= null;
       tail = null;
    }
// insert at last using tail
    public void insert(int value){
        Node node = new Node(value);
        if(head == null ){
            head=node;
            tail=node;
            return;
        }
         tail.next= node;
        node.next= head;
        tail = node;
    }
    //insert using head;
    public void insert2(int value){
        Node node = new Node(value);
        if(head == null ){
            head=node;
            tail=node;
            return;
        }
        Node temp = head;
        while (temp.next != head){
            temp = temp.next;
        }
        temp.next= node;
        node.next = head;
        tail = node;
    }

    //delete a node
    public void delete(int value){
        Node node = head;
        if(node == null){
            return;
        }
        if(node.val == value){
            head = head.next;
            tail.next = head;
            return;
        }

        do{
            Node n = node.next;
            if(n.val == value){
                node.next = n.next;
                break;
            }
            node= node.next;
        }while (node !=head);
    }

    public void dispaly(){
        if(head==null)return;
        if(head.next==null){
            System.out.println(head.val +" end ");
            return;
        }
        Node temp = head;
        do{
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }while (temp != head );
    }

    private class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
