package Graphs.Questions.DijkstraAlgoQuestions;

import java.util.ArrayList;

//You are given two 0-indexed strings source and target, both of length n and consisting of lowercase English letters.
// You are also given two 0-indexed character arrays original and changed, and an integer array cost, where cost[i]
// represents the cost of changing the character original[i] to the character changed[i].
//You start with the string source. In one operation, you can pick a character x from the string and change it to
// the character y at a cost of z if there exists any index j such that cost[j] == z, original[j] == x, and changed[j] == y.
//Return the minimum cost to convert the string source to the string target using any number of operations. If it is impossible to convert source to target, return -1.
//
//Note that there may exist indices i, j such that original[j] == original[i] and changed[j] == changed[i].
//
//Example 1:
//
//Input: source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"], changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
//Output: 28
//Explanation: To convert the string "abcd" to string "acbe":
//        - Change value at index 1 from 'b' to 'c' at a cost of 5.
//        - Change value at index 2 from 'c' to 'e' at a cost of 1.
//        - Change value at index 2 from 'e' to 'b' at a cost of 2.
//        - Change value at index 3 from 'd' to 'e' at a cost of 20.
//The total cost incurred is 5 + 1 + 2 + 20 = 28.
//It can be shown that this is the minimum possible cost.
import java.util.*;
public class MinCostToConvertString1 {

    private static final int CHAR_COUNT = 26;
    private static final int INF = Integer.MAX_VALUE / 2;

    public long minimumCost2(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] conversionGraph = buildConversionGraph(original, changed, cost);
        optimizeConversionPaths(conversionGraph);
        return computeTotalConversionCost(source, target, conversionGraph);
    }

    private int[][] buildConversionGraph(char[] original, char[] changed, int[] cost) {
        int[][] graph = new int[CHAR_COUNT][CHAR_COUNT];
        for (int[] row : graph) {
            Arrays.fill(row, INF);
        }
        for (int i = 0; i < CHAR_COUNT; i++) {
            graph[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            graph[from][to] = Math.min(graph[from][to], cost[i]);
        }
        return graph;
    }

    private void optimizeConversionPaths(int[][] graph) {
        for (int k = 0; k < CHAR_COUNT; k++) {
            for (int i = 0; i < CHAR_COUNT; i++) {
                if (graph[i][k] < INF) {
                    for (int j = 0; j < CHAR_COUNT; j++) {
                        if (graph[k][j] < INF) {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }
    }

    private long computeTotalConversionCost(String source, String target, int[][] graph) {
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int sourceChar = source.charAt(i) - 'a';
            int targetChar = target.charAt(i) - 'a';
            if (sourceChar != targetChar) {
                if (graph[sourceChar][targetChar] == INF) {
                    return -1L;
                }
                totalCost += graph[sourceChar][targetChar];
            }
        }
        return totalCost;
    }
// it will give tle for longer string so we use floyd warshall algorithm
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<List<int[]>> adj = new ArrayList<>();
        int n = original.length;
        for (int i = 0; i <=26; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int from = original[i] -'a';
            int to = changed[i] - 'a';
            int costToReach = cost[i];
            adj.get(from).add(new int[]{to,costToReach});
        }
        int srcLen = source.length();
        int totalCost = 0;
        for (int i = 0; i < srcLen; i++) {
            int src = source.charAt(i) - 'a';
            int tar = target.charAt(i) - 'a';
            if(src == tar)continue;

            PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[0] - y[0]);
            pq.add(new int[]{0,src});
            int[] dist = new int[26];
            Arrays.fill(dist,(int)1e9);
            dist[src] = 0;
            boolean flag = false;
            while (!pq.isEmpty()){
                int[] temp= pq.poll();
                int nodeCost = temp[0];
                int node = temp[1];
                System.out.println(node + " "+ tar);
                if(node == tar) {
                    totalCost += nodeCost;
                    flag = true;
                    break;
                }
                for(int[] it: adj.get(node)){
                    int adjNode = it[0];
                    int edC = it[1];
                    if(nodeCost + edC < dist[adjNode]){
                        dist[adjNode] = nodeCost + edC;
                        pq.add(new int[]{nodeCost+edC,adjNode});
                    }
                }
            }
            if(!flag) return -1;
        }
        return totalCost;
    }
}














