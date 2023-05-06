package Graph.Code;

import java.util.*;

//  https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=strongly-connected-components-kosarajus-algo

public class KosarajuAlgo {
    class Solution
    {
        //Function to find number of strongly connected components in the graph.
        public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
        {
            int[] visited = new int[V];
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < V; i++){
                if(visited[i] == 0){
                    dfs(i, visited, adj, stack);
                }
            }

            ArrayList<ArrayList<Integer>> newAdj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                newAdj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < V; i++){
                visited[i] = 0;
                for(int it: adj.get(i)){
                    newAdj.get(it).add(i);
                }
            }

            int scc = 0;
            while(!stack.isEmpty()){
                int node = stack.pop();
                if(visited[node] == 0){
                    scc++;
                    dfs2(node, visited, newAdj);
                }
            }
            return scc;
        }
        void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack){
            visited[node] = 1;
            for(int n: adj.get(node)){
                if(visited[n] == 0){
                    dfs(n, visited, adj, stack);
                }
            }
            stack.push(node);
        }
        void dfs2(int node, int[] visited, ArrayList<ArrayList<Integer>> newAdj){
            visited[node] = 1;
            for(int it: newAdj.get(node)){
                if(visited[it] == 0){
                    dfs2(it, visited, newAdj);
                }
            }
        }
    }
}
