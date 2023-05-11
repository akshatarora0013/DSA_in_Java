package DynamicProgramming.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

public class _309_Best_time_to_Buy_and_Sell_Stock_with_Cooldown {
    class Solution {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            for(int[] arr: dp){
                Arrays.fill(arr, Integer.MIN_VALUE);
            }
            return maximize(0, prices, 1, dp);
        }
        private int maximize(int index, int[] prices, int buy, int[][] dp){
            if(index >= prices.length){
                return 0;
            }
            if(dp[index][buy] != Integer.MIN_VALUE){
                return dp[index][buy];
            }
            if(buy == 1){
                int case1 = maximize(index+1, prices, 0, dp) - prices[index];
                int case2 = maximize(index+1, prices, 1, dp);
                dp[index][buy] = Math.max(case1, case2);
                return dp[index][buy];
            }
            else{
                int case1 = maximize(index+2, prices, 1, dp) + prices[index];
                int case2 = maximize(index+1, prices, 0, dp);
                dp[index][buy] = Math.max(case1, case2);
                return dp[index][buy];
            }
        }
    }
}
