package Graph.Code;

import java.util.*;

//  https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-from-the-source-bellman-ford-algorithm

public class BellmanFord {
    class Solution {
        static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
            int[] distance = new int[V];
            Arrays.fill(distance, 100000000);
            distance[S] = 0;
            for(int i = 0; i < V-1; i++){
                for(ArrayList<Integer> list: edges){
                    int u = list.get(0);
                    int v = list.get(1);
                    int wt = list.get(2);
                    if(distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]){
                        distance[v] = distance[u] + wt;
                    }
                }
            }
            for(ArrayList<Integer> list: edges){
                int u = list.get(0);
                int v = list.get(1);
                int wt = list.get(2);
                if(distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]){
                    return new int[] {-1};
                }
            }
            return distance;
        }
    }
}
