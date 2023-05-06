package Graph.Questions.LeetCodeHard;

import java.util.*;

//  https://leetcode.com/problems/critical-connections-in-a-network/description/

public class _1192_Critical_Connections_in_a_Network {
    class Solution {
        int timer = 1;
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            List<List<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < n; i++){
                adj.add(new ArrayList<>());
            }
            for(List<Integer> connection: connections){
                int u = connection.get(0);
                int v = connection.get(1);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            List<List<Integer>> bridges = new ArrayList<>();
            int[] visited = new int[n];
            int[] time = new int[n];
            int[] low = new int[n];
            dfs(0, -1, adj, visited, time, low, bridges);
            return bridges;
        }
        private void dfs(int node, int parent, List<List<Integer>> adj, int[] visited, int[] time, int[] low, List<List<Integer>> bridges){
            visited[node] = 1;
            time[node] = timer;
            low[node] = timer;
            timer++;
            for(int it: adj.get(node)){
                if(it == parent){
                    continue;
                }
                if(visited[it] == 0){
                    dfs(it, node, adj, visited, time, low, bridges);
                    low[node] = Math.min(low[node], low[it]);
                    if(low[it] > time[node]){
                        bridges.add(Arrays.asList(it, node));
                    }
                }
                else{
                    low[node] = Math.min(low[node], low[it]);
                }
            }
        }
    }
}
