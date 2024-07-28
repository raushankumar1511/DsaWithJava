package Graphs.Questions.DijkstraAlgoQuestions;

import java.util.*;

class Pair{
    int distance;
    int node;
    public Pair(int dis , int _node){
        distance = dis;
        node = _node;
    }
}
public class DijkstraAlgoUsingMinHeap {
    // using priority queue
//    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
//    {
//        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
//        int[] dist = new int [V];
//        Arrays.fill(dist,(int)1e9);
//        dist[S] = 0;
//        pq.offer(new Pair(0,S));
//
//        while(!pq.isEmpty()){
//            int dis = pq.peek().distance;
//            int node = pq.peek().node;
//            pq.poll();
//
//            for(ArrayList<Integer> it : adj.get(node)){
//                int edgeWeight = it.get(1);
//                int adjNode = it.get(0);
//
//                if(dis + edgeWeight < dist[adjNode]){
//                    dist[adjNode] = dis + edgeWeight;
//                    pq.offer(new Pair(dist[adjNode], adjNode));
//                }
//            }
//        }
//        return dist;
//    }


    //using set method
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        SortedSet<int[]> st = new TreeSet<>((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[S] = 0;
        st.add(new int[]{0, S});

        while (!st.isEmpty()) {
            int[] temp = st.first();
            int dis = temp[0];
            int node = temp[1];
            st.remove(temp);

            for (ArrayList<Integer> it : adj.get(node)) {

                int adjNode = it.get(0);
                int edgeWeight = it.get(1);

                if (dis + edgeWeight < dist[adjNode]) {
                    // Erase if it existed
                    if (dist[adjNode] != (int) 1e9) {
                        st.remove(new int[]{dist[adjNode], adjNode});
                    }
                    dist[adjNode] = dis + edgeWeight;
                    st.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }
        return dist;
    }
}
