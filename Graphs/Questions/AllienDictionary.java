package Graphs.Questions;

import java.util.*;

public class AllienDictionary {
    private ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for (int it:adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        return topo;
    }
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i< N -1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(),s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        ArrayList<Integer> topo = topoSort(K,adj);
          StringBuilder ans = new StringBuilder();
          for(int it: topo){
              ans.append((char) (it + 'a'));
          }
          return ans.toString();
    }
}
