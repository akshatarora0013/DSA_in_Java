package Graph.Questions.LeetCodemedium;

import java.util.*;

//  https://www.youtube.com/watch?v=zQ3zgFypzX4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=12

public class _1559_Detect_Cycles_in_2D_Grid {
    class Solution {
        public boolean containsCycle(char[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(!visited[i][j]){
                        if(dfs(i, j, -1, -1, visited, grid)){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        private boolean dfs(int i, int j, int iP, int jP, boolean[][] visited, char[][] grid){
            visited[i][j] = true;
            int[] delRow = {1, 0, -1, 0};
            int[] delCol = {0, 1, 0, -1};
            for(int k = 0; k < 4; k++){
                int newi = i + delRow[k];
                int newj = j + delCol[k];
                if(newi < 0 || newj < 0 || newi >= grid.length || newj >= grid[0].length || grid[newi][newj] != grid[i][j]){
                    continue;
                }
                if(newi == iP && newj == jP){
                    continue;
                }
                if(visited[newi][newj]){
                    return true;
                }
                if(dfs(newi, newj, i, j, visited, grid)){
                    return true;
                }
            }
            return false;
        }
    }
}
