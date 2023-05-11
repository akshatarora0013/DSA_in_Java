package DynamicProgramming.Questions.LeetCodeMedium;

import java.util.*;

//  https://leetcode.com/problems/coin-change-ii/description/

public class _518_Coin_Change_II {
    // Memoization
//    class Solution {
//        public int change(int amount, int[] coins) {
//            int[][] dp = new int[coins.length][amount+1];
//            for(int[] arr: dp){
//                Arrays.fill(arr, -1);
//            }
//            return count(coins.length-1, amount, coins, dp);
//        }
//        private int count(int index, int amount, int[] coins, int[][] dp){
//            if(index == 0){
//                if(amount % coins[0] == 0){
//                    return 1;
//                }
//                return 0;
//            }
//            if(dp[index][amount] != -1){
//                return dp[index][amount];
//            }
//            int notTake = count(index-1, amount, coins, dp);
//            int take = 0;
//            if(coins[index] <= amount){
//                take = count(index, amount-coins[index], coins, dp);
//            }
//            dp[index][amount] = take + notTake;
//            return take + notTake;
//        }
//    }

    // Tabulation
    class Solution {
        public int change(int amount, int[] coins) {
            int[][] dp = new int[coins.length][amount+1];
            for(int i = 0; i <= amount; i++){
                if(i % coins[0] == 0){
                    dp[0][i] = 1;
                }
                else{
                    dp[0][i] = 0;
                }
            }
            for(int index = 1; index < coins.length; index++){
                for(int j = 0; j <= amount; j++){
                    int notTake = dp[index-1][j];
                    int take = 0;
                    if(coins[index] <= j){
                        take = dp[index][j-coins[index]];
                    }
                    dp[index][j] = take + notTake;
                }
            }
            return dp[coins.length-1][amount];
        }
    }
}
