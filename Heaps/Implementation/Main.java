package Heaps.Implementation;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        heap.insert(8);
        heap.insert(7);
        heap.insert(9);
        heap.insert(10);
        heap.insert(6);

        heap.display();

        ArrayList list = heap.heapSort();
        System.out.println(list);

    }

}
