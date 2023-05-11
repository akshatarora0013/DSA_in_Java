package DynamicProgramming.Questions.LeetCodeHard;

import java.util.*;

//   https://leetcode.com/problems/cherry-pickup-ii/description/

public class _1463_Cherry_Pickup_II {
    // Memoization
    class Solution {
        public int cherryPickup(int[][] grid) {
            int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
            for(int[][] arr: dp){
                for(int[] array: arr){
                    Arrays.fill(array, -1);
                }
            }
            return maxPath(0, 0, grid[0].length-1, dp, grid);
        }
        private int maxPath(int row, int col1, int col2, int[][][] dp, int[][]  grid){
            if(col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length){
                return -1000000;
            }
            if(row == grid.length - 1){
                if(col1 == col2){
                    return grid[row][col1];
                }
                else{
                    return grid[row][col1] + grid[row][col2];
                }
            }
            if(dp[row][col1][col2] != -1){
                return dp[row][col1][col2];
            }
            int max = -1;
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    if(col1 == col2){
                        max = Math.max(max, grid[row][col1] + maxPath(row+1, col1+i, col2+j, dp, grid));
                    }
                    else{
                        max = Math.max(max, grid[row][col1] + grid[row][col2] + maxPath(row+1, col1+i, col2+j, dp, grid));
                    }
                }
            }
            dp[row][col1][col2] = max;
            return max;
        }
    }

    // Tabulation
//    class Solution {
//        public int cherryPickup(int[][] grid) {
//            int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
//            for(int col1 = 0; col1 < grid[0].length; col1++){
//                for(int col2 = 0; col2 < grid[0].length; col2++){
//                    if(col1 == col2){
//                        dp[grid.length-1][col1][col2] = grid[grid.length-1][col1];
//                    }
//                    else{
//                        dp[grid.length-1][col1][col2] = grid[grid.length-1][col1] + grid[grid.length-1][col2];
//                    }
//                }
//            }
//            for(int row = grid.length-2; row >= 0; row--){
//                for(int col1 = 0; col1 < grid[0].length; col1++){
//                    for(int col2 = 0; col2 < grid[0].length; col2++){
//                        int max = -1;
//                        for(int i = -1; i <= 1; i++){
//                            for(int j = -1; j <= 1; j++){
//                                if(col1+i >= 0 && col1+i < grid[0].length && col2+j >= 0 && col2+j < grid[0].length){
//                                    if(col1 == col2){
//                                        max = Math.max(max, grid[row][col1] + dp[row+1][col1+i][col2+j]);
//                                    }
//                                    else{
//                                        max = Math.max(max, grid[row][col1] + grid[row][col2] + dp[row+1][col1+i][col2+j]);
//                                    }
//                                }
//                            }
//                        }
//                        dp[row][col1][col2] = max;
//                    }
//                }
//            }
//            return dp[0][0][grid[0].length-1];
//        }
//    }
}
