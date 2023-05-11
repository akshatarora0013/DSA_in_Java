package DynamicProgramming.Questions.LeetCodeMedium;

import java.util.*;

//   https://leetcode.com/problems/unique-paths/description/

public class _62_Unique_Paths {
    // memoization
//    class Solution {
//        public int uniquePaths(int m, int n) {
//            int[][] dp = new int[m][n];
//            for(int[] arr: dp){
//                Arrays.fill(arr, -1);
//            }
//            return count(0,0,m,n,dp);
//        }
//        private int count(int row, int col, int m, int n, int[][] dp){
//            if(row == m-1 && col == n-1){
//                return 1;
//            }
//            if(dp[row][col] != -1){
//                return dp[row][col];
//            }
//            int right = 0;
//            int down = 0;
//            if(row+1 < m){
//                down = count(row+1, col, m, n, dp);
//            }
//            if(col+1 < n){
//                right = count(row, col+1, m, n, dp);
//            }
//            dp[row][col] = right + down;
//            return right + down;
//        }
//    }

    // tabulation
//    class Solution {
//        public int uniquePaths(int m, int n) {
//            int[][] dp = new int[m][n];
//            for(int[] arr: dp){
//                Arrays.fill(arr, -1);
//            }
//            dp[m-1][n-1] = 1;
//            for(int row = m-1; row >= 0; row--){
//                for(int col = n-1; col >=0; col--){
//                    if(row == m-1 && col == n-1){
//                        continue;
//                    }
//                    int right = 0;
//                    int down = 0;
//                    if(row < m-1){
//                        down = dp[row+1][col];
//                    }
//                    if(col < n-1){
//                        right = dp[row][col+1];
//                    }
//                    dp[row][col] = down+right;
//                }
//            }
//            return dp[0][0];
//        }
//    }


}
