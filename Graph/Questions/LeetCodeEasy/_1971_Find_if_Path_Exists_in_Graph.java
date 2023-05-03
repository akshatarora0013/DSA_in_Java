package Graph.Questions.LeetCodeEasy;

import java.util.*;

//  https://leetcode.com/problems/find-if-path-exists-in-graph/description/

public class _1971_Find_if_Path_Exists_in_Graph {
    class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for(int[] edge: edges){
                int v1 = edge[0];
                int v2 = edge[1];
                if(map.containsKey(v1)){
                    map.get(v1).add(v2);
                }
                else{
                    map.put(v1, new ArrayList<>());
                    map.get(v1).add(v2);
                }
                if(map.containsKey(v2)){
                    map.get(v2).add(v1);
                }
                else{
                    map.put(v2, new ArrayList<>());
                    map.get(v2).add(v1);
                }
            }

            boolean[] seen = new boolean[n];
            seen[source] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);

            while(!queue.isEmpty()){
                int vtx = queue.poll();
                if(vtx == destination){
                    return true;
                }

                for(int v : map.get(vtx)){
                    if(!seen[v]){
                        seen[v] = true;
                        queue.offer(v);
                    }
                }
            }
            return false;
        }
    }
}
