package DynamicProgramming.Questions.LeetCodeHard;

//  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

public class _123_Best_Time_to_Buy_and_Sell_Stock_III {
    // Memoization
//    class Solution {
//        public int maxProfit(int[] prices) {
//            int[][][] dp = new int[prices.length][2][3];
//            for(int[][] arr: dp){
//                for(int[] array: arr){
//                    Arrays.fill(array, Integer.MIN_VALUE);
//                }
//            }
//            return maximize(0, prices, 1, dp, 2);
//        }
//        private int maximize(int index, int[] prices, int buy, int[][][] dp, int cap){
//            if(index == prices.length){
//                return 0;
//            }
//            if(cap == 0){
//                return 0;
//            }
//            if(dp[index][buy][cap] != Integer.MIN_VALUE){
//                return dp[index][buy][cap];
//            }
//            if(buy == 1){
//                int case1 = maximize(index+1, prices, 0, dp, cap) - prices[index];
//                int case2 = maximize(index+1, prices, 1, dp, cap);
//                dp[index][buy][cap] = Math.max(case1, case2);
//                return dp[index][buy][cap];
//            }
//            else{
//                int case1 = maximize(index+1, prices, 1, dp, cap-1) + prices[index];
//                int case2 = maximize(index+1, prices, 0, dp, cap);
//                dp[index][buy][cap] = Math.max(case1, case2);
//                return dp[index][buy][cap];
//            }
//        }
//    }

    // Tabulation
//    class Solution {
//        public int maxProfit(int[] prices) {
//            int[][][] dp = new int[prices.length+1][2][3];
//            for(int index = prices.length-1; index >=0; index--){
//                for(int buy = 0; buy < 2; buy++){
//                    for(int cap = 1; cap < 3; cap++){
//                        if(buy == 1){
//                            int case1 = dp[index+1][0][cap] - prices[index];
//                            int case2 = dp[index+1][1][cap];
//                            dp[index][buy][cap] = Math.max(case1, case2);
//                        }
//                        else{
//                            int case1 = dp[index+1][1][cap-1] + prices[index];
//                            int case2 = dp[index+1][0][cap];
//                            dp[index][buy][cap] = Math.max(case1, case2);
//                        }
//                    }
//                }
//            }
//            return dp[0][1][2];
//        }
//    }

    // space optimised
    class Solution {
        public int maxProfit(int[] prices) {
            int[][] after = new int[2][3];
            int[][] curr = new int[2][3];
            for(int index = prices.length-1; index >=0; index--){
                for(int buy = 0; buy < 2; buy++){
                    for(int cap = 1; cap < 3; cap++){
                        if(buy == 1){
                            int case1 = after[0][cap] - prices[index];
                            int case2 = after[1][cap];
                            curr[buy][cap] = Math.max(case1, case2);
                        }
                        else{
                            int case1 = after[1][cap-1] + prices[index];
                            int case2 = after[0][cap];
                            curr[buy][cap] = Math.max(case1, case2);
                        }
                    }
                }
                after = curr;
            }
            return after[1][2];
        }
    }
}
