package DynamicProgramming.Questions.LeetCodeHard;

//  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/

public class _188_Best_Time_to_Buy_and_Sell_Stock_IV {
    // memoization
//    class Solution {
//        public int maxProfit(int k, int[] prices) {
//            int[][] dp = new int[prices.length][k*2 + 1];
//            for(int[] arr: dp){
//                Arrays.fill(arr, -1);
//            }
//            return maximize(0, prices, dp, k*2);
//        }
//        private int maximize(int index, int[] prices, int[][] dp, int cap){
//            if(index == prices.length || cap == 0){
//                return 0;
//            }
//            if(dp[index][cap] != -1){
//                return dp[index][cap];
//            }
//            if(cap % 2 == 0){
//                int case1 = maximize(index+1, prices, dp, cap-1) - prices[index];
//                int case2 = maximize(index+1, prices, dp, cap);
//                dp[index][cap] = Math.max(case1, case2);
//                return dp[index][cap];
//            }
//            else{
//                int case1 = maximize(index+1, prices, dp, cap-1) + prices[index];
//                int case2 = maximize(index+1, prices, dp, cap);
//                dp[index][cap] = Math.max(case1, case2);
//                return dp[index][cap];
//            }
//        }
//    }

    // Tabulation

//    class Solution {
//        public int maxProfit(int k, int[] prices) {
//            int[][] dp = new int[prices.length+1][(k*2)+1];
//            for(int index = prices.length-1; index >= 0; index--){
//                for(int cap = 1; cap <= 2*k; cap++){
//                    //buy
//                    if(cap % 2 == 0){
//                        int case1 = dp[index+1][cap-1] - prices[index];
//                        int case2 = dp[index+1][cap];
//                        dp[index][cap] = Math.max(case1, case2);
//                    }
//                    //sell
//                    else{
//                        int case1 = dp[index+1][cap-1] + prices[index];
//                        int case2 = dp[index+1][cap];
//                        dp[index][cap] = Math.max(case1, case2);
//                    }
//                }
//            }
//
//            return dp[0][2*k];
//        }
//    }

    // space optimised
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int[] prev = new int[(k*2) + 1];
            int[] curr = new int[k*2 + 1];
            for(int index = prices.length-1; index >= 0; index--){
                for(int cap = 1; cap <= 2*k; cap++){
                    //buy
                    if(cap % 2 == 0){
                        int case1 = prev[cap-1] - prices[index];
                        int case2 = prev[cap];
                        curr[cap] = Math.max(case1, case2);
                    }
                    //sell
                    else{
                        int case1 = prev[cap-1] + prices[index];
                        int case2 = prev[cap];
                        curr[cap] = Math.max(case1, case2);
                    }
                }
                prev = curr;
            }

            return prev[2*k];
        }
    }
}
