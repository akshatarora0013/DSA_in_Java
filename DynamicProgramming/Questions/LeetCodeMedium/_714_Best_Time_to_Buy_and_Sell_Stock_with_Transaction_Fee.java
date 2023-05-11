package DynamicProgramming.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

public class _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
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
                        int case1 = prev[1] + prices[index] - fee;
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
