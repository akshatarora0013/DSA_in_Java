package Graph.Questions.LeetCodemedium;

import java.util.*;

//   https://leetcode.com/problems/number-of-islands/description/

public class _200_Number_of_Islands {
    class Solution {
        public int numIslands(char[][] grid) {
            int ans = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == '1'){
                        ans++;
                        merge(grid, i, j);
                    }
                }
            }
            return ans;
        }
        private void merge(char[][] grid, int i, int j){
            if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
                return;
            }
            if(grid[i][j] == '1'){
                grid[i][j] = '0';
                merge(grid, i-1, j);
                merge(grid, i+1, j);
                merge(grid, i, j-1);
                merge(grid, i, j+1);
            }
        }
    }
}
