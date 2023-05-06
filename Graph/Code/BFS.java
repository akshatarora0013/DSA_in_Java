package Graph.Code;

import java.util.*;

//   https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

public class BFS {
    class Solution {
        // Function to return Breadth First Traversal of given graph.
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[V];

            ArrayList<Integer> bfs = new ArrayList<>();

            queue.add(0);
            visited[0] = true;

            while(!queue.isEmpty()){
                int rm = queue.poll();
                bfs.add(rm);
                for(int item: adj.get(rm)){
                    if(!visited[item]){
                        queue.add(item);
                        visited[item] = true;
                    }
                }
            }

            return bfs;
        }
    }
}
