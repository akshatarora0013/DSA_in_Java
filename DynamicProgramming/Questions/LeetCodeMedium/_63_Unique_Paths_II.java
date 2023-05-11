package DynamicProgramming.Questions.LeetCodeMedium;

import java.util.*;

//   https://leetcode.com/problems/unique-paths-ii/description/

public class _63_Unique_Paths_II {
    // Memoization
//    class Solution {
//        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//            if (obstacleGrid[0][0] == 1) {
//                return 0;
//            }
//            int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
//            for(int[] arr: dp){
//                Arrays.fill(arr, -1);
//            }
//            return count(0,0,obstacleGrid,dp);
//        }
//        private int count(int row, int col, int[][] obstacleGrid, int[][] dp){
//            if(row == obstacleGrid.length-1 && col == obstacleGrid[0].length-1){
//                return 1;
//            }
//            if(dp[row][col] != -1){
//                return dp[row][col];
//            }
//            int right = 0;
//            int down = 0;
//            if(row+1 <  obstacleGrid.length && obstacleGrid[row+1][col] != 1){
//                down = count(row+1, col, obstacleGrid, dp);
//            }
//            if(col+1 < obstacleGrid[0].length && obstacleGrid[row][col+1] != 1){
//                right = count(row, col+1, obstacleGrid, dp);
//            }
//            dp[row][col] = right + down;
//            return right + down;
//        }
//    }

    // Tabulation
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid[0][0] == 1) {
                return 0;
            }
            int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
            for(int[] arr: dp){
                Arrays.fill(arr, -1);
            }
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            dp[m-1][n-1] = 1;
            for(int row = m-1; row >= 0; row--){
                for(int col = n-1; col >=0; col--){
                    if(row == m-1 && col == n-1){
                        continue;
                    }
                    int right = 0;
                    int down = 0;
                    if(row < m-1 && obstacleGrid[row+1][col] != 1){
                        down = dp[row+1][col];
                    }
                    if(col < n-1 && obstacleGrid[row][col+1] != 1){
                        right = dp[row][col+1];
                    }
                    dp[row][col] = down+right;
                }
            }
            return dp[0][0];
        }
    }
}
