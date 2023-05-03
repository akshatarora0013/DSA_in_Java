package Graph.Questions.LeetCodemedium;

//  https://leetcode.com/problems/is-graph-bipartite/description/

public class _785_Is_Graph_Bipartite {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int[] color = new int[graph.length];
            for(int i = 0; i < color.length; i++){
                color[i] = -1;
            }
            for(int i = 0; i < graph.length; i++){
                if(color[i] == -1){
                    if(!dfs(graph, color, 0, i)){
                        return false;
                    }
                }
            }
            return true;
        }
        private boolean dfs(int[][] graph, int[] color, int col, int node){
            color[node] = col;
            for(int it: graph[node]){
                if(color[it] == -1){
                    if(!dfs(graph, color, 1-col, it)){
                        return false;
                    }
                }
                else if(color[it] == col){
                    return false;
                }
            }
            return true;
        }
    }
}
