package Linklistwhole.DoublyLInkList;

public class DLL {
    Node head;

    public void insertFirst(int val){
        Node node = new Node(val);
        node.prev=null;
        node.next=head;
        if(head !=null){
            head.prev=node;
        }
        head=node;
    }

    public void insertLast(int val){
        //creating new node
        Node newNode = new Node(val);
        Node temp = head;

        newNode.next = null;
  
        if(head ==null){
            newNode.prev=null;
            head=newNode;
            return;
        }

        while (temp.next!= null){
            temp= temp.next;
        }

        temp.next= newNode;
        newNode.prev=temp;
    }

    public void insertAfterNode(int after,int val){
        Node p = find(after);
        if(p==null){
            System.out.println("node not exist in list");
            return;
        }

        Node new_node = new Node(val);
        new_node.next= p.next;
        p.next= new_node;
        new_node.prev= p;
        if(new_node.next !=null){
            new_node.next.prev = new_node;
        }
    }
    public Node find(int value){
        Node temp = head;
        while (temp!=null){
            if(temp.val==value ){
                return temp;
            }
            temp= temp.next;
        }
        return null;
    }

    public void delete(int nodeValue){
        Node toDelete = find(nodeValue);

        toDelete.prev.next =toDelete.next;
        if(toDelete.next!= null){
            toDelete.next.prev = toDelete.prev;
        }

    }
    public void display(){
        Node node = head;
        while(node!=null){
            System.out.print(node.val+ " -> ");
            node=node.next;
        }
        System.out.println("END");
    }
    public void displayRev(){
        Node last = head;
        while(last.next!=null){
            last=last.next;
        }
        System.out.println("print in rev");
        while (last!=null){
            System.out.print(last.val+ " -> ");
            last=last.prev;
        }
        System.out.println("Start ");
    }

    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void reverseDLL(){
        if(head==null || head.next ==null)return;
        Node curr = head;
        Node pre = null;
        while (curr != null){
            pre = curr.prev;
            curr.prev= curr.next;
            curr.next= pre;
            curr = curr.prev;
        }
        head= pre.prev;
    }
}
