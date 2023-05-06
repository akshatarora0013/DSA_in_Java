package Graph.Code;

import java.util.*;

//  https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

public class DFS {
    class Solution {
        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            boolean[] visited = new boolean[V+1];

            ArrayList<Integer> ls = new ArrayList<>();
            visited[0] = true;

            dfs(0, visited, adj, ls);
            return ls;


        }
        void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){

            visited[node] = true;
            ls.add(node);

            for(int item: adj.get(node)){
                if(!visited[item]){
                    dfs(item, visited, adj, ls);
                }
            }
        }
    }
}
