package Linklistwhole.DoublyLInkList;

public class Main {
    public static void main(String[] args) {
        DLL list = new DLL();

        list.insertFirst(4);
        list.insertFirst(6);
        list.insertFirst(23);
        list.insertFirst(9);

        list.display();
        list.displayRev();

        list.insertLast(5);
        list.insertLast(99);

        list.insertAfterNode(99,65);
        list.display();
        list.delete(23);
        list.display();

        list.reverseDLL();
        list.display();
    }
}
