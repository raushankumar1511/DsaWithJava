package Graphs.Implementation;

import java.util.ArrayList;

public class GraphUsingList {
    public static void main(String[] args) {
        int n =3;// no of nodes
        int m = 3;// no of edges

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        //n+1 nested lists insert
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        //edge 1---2
        adj.get(1).add(2);
        adj.get(2).add(1);

//        //for any u ---- v edge      // if it is directed graph then we only add one dimension or edge
//        adj.get(u).add(v);           // adj.get(u).add(v);
//        adj.get(v).add(u);

        //edge 2---3
        adj.get(2).add(3);
        adj.get(3).add(2);

        //edge 1---3
        adj.get(1).add(3);
        adj.get(3).add(1);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();

        }
    }
}
