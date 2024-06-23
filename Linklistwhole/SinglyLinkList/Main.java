package Linklistwhole.SinglyLinkList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

//        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(6);
        list.insertFirst(23);

        list.insertLast(8);
        list.insertLast(65);
        list.insertLast(1);

        list.insert(100,3);
        list.insert(45,0);

        list.display();

        //deleting nodes from first
        System.out.println(list.deleteFirst());
        //deleting nodes from last;
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.deleteLast2());
        list.display();

        System.out.println(list.delete(2));
        list.display();

        list.insertRec(88,2);
        list.display();

    }
}
