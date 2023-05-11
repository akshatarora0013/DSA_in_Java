package DynamicProgramming.Questions.LeetCodeEasy;

import java.util.*;

//   https://leetcode.com/problems/climbing-stairs/description/

public class _70_Climbing_Stairs {
    class Solution {
        private int memoization(int n, int[] dp){
            if(n <= 1){
                dp[n] = 1;
                return 1;
            }
            if(dp[n] != -1){
                return dp[n];
            }
            dp[n] = memoization(n-1, dp) + memoization(n-2, dp);
            return memoization(n-1, dp) + memoization(n-2, dp);
        }
        public int climbStairs(int n) {
            int[] dp = new int[n+1];
            Arrays.fill(dp, -1);
            return memoization(n, dp);


            //Tabulation
            // int[] dp = new int[n+1];
            // dp[0] = 1;
            // dp[1] = 1;
            // for(int i = 2; i <= n; i++){
            //     dp[i] = dp[i-1] + dp[i-2];
            // }
            // return dp[n];

            // Space Optimized Tabulation
            // int prev = 1;
            // int prev1 = 1;
            // for(int i = 2; i <= n; i++){
            //     int curri = prev + prev1;
            //     prev1 = prev;
            //     prev = curri;
            // }
            // return prev;
        }
    }
}
