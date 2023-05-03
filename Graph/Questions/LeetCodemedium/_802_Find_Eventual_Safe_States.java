package Graph.Questions.LeetCodemedium;

import java.util.*;

//  https://leetcode.com/problems/find-eventual-safe-states/description/

public class _802_Find_Eventual_Safe_States {
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int[] visited = new int[graph.length];
            int[] pathVisited = new int[graph.length];
            int[] check = new int[graph.length];
            for(int i = 0; i < graph.length; i++){
                if(visited[i] == 0){
                    dfs(i, graph, visited, pathVisited, check);
                }
            }
            List<Integer> safeNodes = new ArrayList<>();
            for(int i = 0; i < check.length; i++){
                if(check[i] == 1){
                    safeNodes.add(i);
                }
            }
            return safeNodes;
        }

        private boolean dfs(int node, int[][] graph, int[] visited, int[] pathVisited, int[] check){
            visited[node] = 1;
            pathVisited[node] = 1;
            check[node] = 0;

            for(int item: graph[node]){
                if(visited[item] == 0){
                    if(dfs(item, graph, visited, pathVisited, check)){
                        return true;
                    }
                }
                else if(pathVisited[item] == 1){
                    return true;
                }
            }
            check[node] = 1;
            pathVisited[node] = 0;
            return false;
        }
    }
}
