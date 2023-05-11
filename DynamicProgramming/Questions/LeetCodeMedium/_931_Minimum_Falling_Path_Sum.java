package DynamicProgramming.Questions.LeetCodeMedium;

import java.util.*;

//   https://leetcode.com/problems/minimum-falling-path-sum/description/

public class _931_Minimum_Falling_Path_Sum {
    // memoization
//    class Solution {
//        public int minFallingPathSum(int[][] matrix) {
//            int result = 1000000;
//            int[][] dp = new int[matrix.length][matrix[0].length];
//            for(int[] arr: dp){
//                Arrays.fill(arr, -1);
//            }
//            for(int j = 0; j < matrix[0].length; j++){
//                result = Math.min(result, pathSum(0, j, dp, matrix));
//            }
//            return result;
//        }
//        private int pathSum(int i, int j, int[][] dp, int[][] matrix){
//            if(i == matrix.length-1){
//                return matrix[i][j];
//            }
//            if(dp[i][j] != -1){
//                return dp[i][j];
//            }
//            int left = 10000000;
//            int right = 10000000;
//            if(j-1 >= 0){
//                left = matrix[i][j] + pathSum(i+1, j-1, dp, matrix);
//            }
//            int down = matrix[i][j] + pathSum(i+1, j, dp, matrix);
//            if(j+1 < matrix[0].length){
//                right = matrix[i][j] + pathSum(i+1, j+1, dp, matrix);
//            }
//            int min = Math.min(left, Math.min(down, right));
//            dp[i][j] = min;
//            return min;
//        }
//    }

    // Tabulation
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int result = 1000000;
            int[][] dp = new int[matrix.length][matrix[0].length];
            for(int[] arr: dp){
                Arrays.fill(arr, -1);
            }
            for(int j = 0; j < matrix[0].length; j++){
                dp[matrix.length-1][j] = matrix[matrix.length-1][j];
            }
            for(int i = matrix.length-2; i >= 0; i--){
                for(int j = 0; j < matrix[0].length; j++){
                    int left = 1000000;
                    if(j-1 >= 0){
                        left = matrix[i][j] + dp[i+1][j-1];
                    }
                    int up = matrix[i][j] + dp[i+1][j];
                    int right = 1000000;
                    if(j+1 < matrix[0].length){
                        right = matrix[i][j] + dp[i+1][j+1];
                    }
                    dp[i][j] = Math.min(left, Math.min(up, right));
                }
            }
            int min = dp[0][0];
            for(int i = 1; i < matrix[0].length; i++){
                if(dp[0][i] < min){
                    min = dp[0][i];
                }
            }
            return min;
        }
    }
}
