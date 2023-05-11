package DynamicProgramming.Questions.LeetCodeMedium;

import java.util.*;

//

public class _64_Minimum_Path_Sum {
    //  Memoization
//    class Solution {
//        public int minPathSum(int[][] grid) {
//            int[][] dp = new int[grid.length][grid[0].length];
//            for(int[] arr: dp){
//                Arrays.fill(arr, -1);
//            }
//            return pathSum(grid.length-1, grid[0].length-1, dp, grid);
//        }
//        private int pathSum(int i, int j, int[][] dp, int[][] grid){
//            if(i == 0 && j == 0){
//                return grid[0][0];
//            }
//            if(i <0 || j < 0){
//                return 1000000;
//            }
//            if(dp[i][j] != -1){
//                return dp[i][j];
//            }
//            int up = grid[i][j] + pathSum(i-1, j, dp, grid);
//            int left = grid[i][j] + pathSum(i, j-1, dp, grid);
//            dp[i][j] = Math.min(up, left);
//            return dp[i][j];
//        }
//    }

    //  Tabulation
    class Solution {
        public int minPathSum(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];
            for(int[] arr: dp){
                Arrays.fill(arr, -1);
            }
            dp[0][0] = grid[0][0];
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(i == 0 && j == 0){
                        continue;
                    }
                    int up = 100000;
                    int left = 100000;
                    if(i-1 >= 0){
                        up = grid[i][j] + dp[i-1][j];
                    }
                    if(j-1 >= 0){
                        left = grid[i][j] + dp[i][j-1];
                    }
                    dp[i][j] = Math.min(up, left);
                }
            }
            return dp[grid.length-1][grid[0].length-1];
        }
    }
}
