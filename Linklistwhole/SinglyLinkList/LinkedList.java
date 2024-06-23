package Linklistwhole.SinglyLinkList;

public class LinkedList {
    private Node head;
    private Node tail;
    public int size;
    public LinkedList(){
        this.size = 0;
    }
    //linklist node creation
    private class Node{
        private int value;
        private Node next;

        public Node(){}
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size +=1;
    }
    //insert at the last using head;
    public void insertLast(int val) {
        Node new_node = new Node(val);
        if (head == null) {
            head = new_node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
            tail= new_node;
        }
        size++;
    }
        //insert at last using tail;
    public void insertLast2(int val){
            if(tail==null){
                insertFirst(val);
                return;
            }
            Node new_node = new Node(val);
            tail.next=new_node;
            tail=new_node;
            size++;
    }
    //insert at the particular index;
    public void insert(int val , int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size ){
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node new_node = new Node(val,temp.next);
        temp.next=new_node;

        size++;
    }

    //insert using recursion
    public void insertRec(int val ,int index){
        head = insertRec(val,index,head);
    }
    private Node insertRec(int val, int index ,Node node){
        if(index==0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }
        System.out.println(index);
        node.next= insertRec(val,index-1,node.next);
        return node;
    }


    //delete from first
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail= null;
        }
        size --;
        return val;
    }

    //delete from last
    public int deleteLast(){
        Node temp = head;
        if(temp.next == null){
            return deleteFirst();
        }
        while (temp.next.next != null){
            temp = temp.next;
        }
        int val = temp.next.value;
        temp.next = null;

        size--;
        return val;

    }

    //delete from last using tail;
    public int deleteLast2(){
        if(size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int deletedNodeval = tail.value;
        tail = secondLast;
        tail.next = null;

        size--;
        return deletedNodeval;
    }

    //getting node
    public Node get(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp= temp.next;
        }
        return temp;
    }

    //deleting node from particular index
    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size -1){
            return deleteLast();
        }
        Node prev = get(index-1);
        int val = prev.next.value;

        prev.next = prev.next.next;

        size--;
        return val;
    }

    //displaying the value;
    public void display(){
        Node temp = head;
        while (temp!= null){
            System.out.print(temp.value + "-> ");
            temp = temp.next;
        }
        System.out.println("End");
    }
    //display using head;
    public static void display(Node node){
        Node temp = node;
        while (temp!= null){
            System.out.print(temp.value + "-> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

/*--------------QUESTIONS---------------------------*/
    //questions
    public void duplicates(){
        Node node = head;

        while(node.next != null){
            if( node.value == node.next.value){
                node.next = node.next.next;
                size--;
            }else {
                node= node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // MERGE TWO SORTED LINKLIST leetcode
//    public  Node mergeTwoLists(Node list1, Node list2) {
//        Node ansHead = new Node();
//        Node ansTail = ansHead;
//        while(list1 != null && list2 != null){
//            if(list1.value < list2.value){
//                ansTail.next = list1;
//                list1 = list1.next;
//                ansTail = ansTail.next;
//            }else{
//                ansTail.next = list2;
//                list2 = list2.next;
//                ansTail = ansTail.next;
//            }
//        }
//        if(list1 != null){
//            ansTail.next = list1;
//        }
//        if(list2 != null){
//            ansTail.next = list2;
//        }
//        return ansHead.next;
//    }
    public static LinkedList merge(LinkedList first , LinkedList second){
        Node fh = first.head;
        Node sh = second.head;

        LinkedList ans = new LinkedList();

        while (fh != null && sh != null){
            if(fh.value < sh.value){
                ans.insertLast(fh.value);
                fh= fh.next;
            }else{
                ans.insertLast(sh.value);
                sh = sh.next;
            }
        }
        while (fh != null){
            ans.insertLast(fh.value);
            fh = fh.next;
        }
        while (sh != null){
            ans.insertLast(sh.value);
            sh = sh.next;
        }
        return ans;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(5);
        list.insertLast(5);
        list.insertLast(9);

        LinkedList list2 = new LinkedList();
        list2.insertLast(2);
        list2.insertLast(3);
        list2.insertLast(7);
//        list.display();
//        list.duplicates();
//        list.display();

        LinkedList ans = LinkedList.merge(list, list2);
        ans.display();
    }



}
