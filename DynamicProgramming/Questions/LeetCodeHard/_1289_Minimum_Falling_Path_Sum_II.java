package DynamicProgramming.Questions.LeetCodeHard;

import java.util.*;

//  https://leetcode.com/problems/minimum-falling-path-sum-ii/description/

public class _1289_Minimum_Falling_Path_Sum_II {
    // Memoization
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int result = 1000000;
            int[][] dp = new int[matrix.length][matrix[0].length];
            for(int[] arr: dp){
                Arrays.fill(arr, -1);
            }
            for(int j = 0; j < matrix[0].length; j++){
                result = Math.min(result, pathSum(0, j, dp, matrix));
            }
            return result;
        }
        private int pathSum(int row, int col, int[][] dp, int[][] matrix){
            if(row == matrix.length-1){
                return matrix[row][col];
            }
            if(col >= matrix.length){
                return Integer.MAX_VALUE;
            }
            if(dp[row][col] != -1){
                return dp[row][col];
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0 ; i < matrix.length ; i++){
                if(i != col)
                    min = Math.min(min , matrix[row][col] + pathSum(row+1, i, dp, matrix));
            }
            dp[row][col] = min;
            return min;
        }
    }
}
