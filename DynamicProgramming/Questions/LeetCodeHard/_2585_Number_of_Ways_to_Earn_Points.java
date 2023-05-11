package DynamicProgramming.Questions.LeetCodeHard;

import java.util.*;

//   https://leetcode.com/problems/number-of-ways-to-earn-points/description/

public class _2585_Number_of_Ways_to_Earn_Points {
    class Solution {
        static int mod = (int)Math.pow(10,9)+7;
        public int waysToReachTarget(int target, int[][] types) {
            int dp[][] = new int[types.length][target+1];
            for(int[] arr: dp){
                Arrays.fill(arr, -1);
            }
            return count(types.length-1, target, types, dp);
        }
        private int count(int questionType, int target, int[][] types, int[][] dp){
            if(target < 0){
                return 0;
            }
            if(target == 0){
                return 1;
            }
            if(dp[questionType][target] != -1){
                return dp[questionType][target];
            }
            if(questionType == 0){
                int counter = 0;
                for(int i = 0; i <= types[0][0]; i++){
                    if(target - i*types[0][1] == 0){
                        counter = (counter+1) % mod;
                    }
                }
                return counter % mod;
            }
            int counter = 0;
            for(int i = 0; i <= types[questionType][0]; i++){
                counter = (counter + count(questionType-1, target-i*types[questionType][1], types,dp)) % mod;
            }
            dp[questionType][target] = counter % mod;
            return counter % mod;
        }
    }
}
