package DynamicProgramming.Questions.LeetCodeMedium;

import java.util.*;

//   https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

public class _122_Best_Time_to_Buy_and_Sell_Stock_II {
    // Memoization
//    class Solution {
//        public int maxProfit(int[] prices) {
//            int[][] dp = new int[prices.length][2];
//            for(int[] arr: dp){
//                Arrays.fill(arr, Integer.MIN_VALUE);
//            }
//            return maximize(0, prices, 1, dp);
//        }
//        private int maximize(int index, int[] prices, int buy, int[][] dp){
//            if(index == prices.length){
//                return 0;
//            }
//            if(dp[index][buy] != Integer.MIN_VALUE){
//                return dp[index][buy];
//            }
//            if(buy == 1){
//                int case1 = maximize(index+1, prices, 0, dp) - prices[index];
//                int case2 = maximize(index+1, prices, 1, dp);
//                dp[index][buy] = Math.max(case1, case2);
//                return dp[index][buy];
//            }
//            else{
//                int case1 = maximize(index+1, prices, 1, dp) + prices[index];
//                int case2 = maximize(index+1, prices, 0, dp);
//                dp[index][buy] = Math.max(case1, case2);
//                return dp[index][buy];
//            }
//        }
//    }

    // Tabulation
//    class Solution {
//        public int maxProfit(int[] prices) {
//            int[][] dp = new int[prices.length+1][2];
//            dp[prices.length][0] = 0;
//            dp[prices.length][1] = 0;
//            for(int index = prices.length-1; index >= 0; index--){
//                for(int buy = 0; buy < 2; buy++){
//                    if(buy == 1){
//                        int case1 = dp[index+1][0] - prices[index];
//                        int case2 = dp[index+1][1];
//                        dp[index][buy] = Math.max(case1, case2);
//                    }
//                    else{
//                        int case1 = dp[index+1][1] + prices[index];
//                        int case2 = dp[index+1][0];
//                        dp[index][buy] = Math.max(case1, case2);
//                    }
//                }
//            }
//            return dp[0][1];
//        }
//    }

    // contant space used
    class Solution {
        public int maxProfit(int[] prices) {
            int[] prev = new int[2];
            prev[0] = 0;
            prev[1] = 0;
            int[] curr = new int[2];
            for(int index = prices.length-1; index >= 0; index--){
                for(int buy = 0; buy < 2; buy++){
                    if(buy == 1){
                        int case1 = prev[0] - prices[index];
                        int case2 = prev[1];
                        curr[buy] = Math.max(case1, case2);
                    }
                    else{
                        int case1 = prev[1] + prices[index];
                        int case2 = prev[0];
                        curr[buy] = Math.max(case1, case2);
                    }
                }
                prev = curr;
            }
            return prev[1];
        }
    }
}
