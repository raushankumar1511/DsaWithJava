package Graphs.Questions.DijkstraAlgoQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationToReachEnd {
    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start,0});
        int[] dist = new int[100000];
        Arrays.fill(dist,(int)1e9);
        dist[start] = 0;
        int mod = 100000;

        while(!q.isEmpty()){
            int node = q.peek()[0];
            int steps = q.peek()[1];
            q.poll();

            for(int it : arr){
                int num  = (it * node) % mod;
                if(steps + 1 < dist[num]){
                    dist[num] = steps +1;
                    if(num == end)return steps + 1;
                    q.offer(new int[]{num, steps + 1});
                }
            }
        }
        return -1;
    }
}

