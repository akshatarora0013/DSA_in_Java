package DynamicProgramming.Questions.LeetCodeHard;

import java.util.*;

//  https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/description/

public class _2218_Maximum_Value_of_K_Coins_From_Piles {
    class Solution {
        public int maxValueOfCoins(List<List<Integer>> piles, int k) {
            Integer[][] dp = new Integer[piles.size()][k+1];
            return count(piles.size()-1, piles, k, dp);
        }
        private int count(int index, List<List<Integer>> piles, int k, Integer[][] dp){
            if(index < 0 || k == 0){
                return 0;
            }
            if(dp[index][k] != null){
                return dp[index][k];
            }
            int notTake = count(index-1, piles, k, dp);
            int coinsLimit = Math.min(k, piles.get(index).size());
            int take = 0;
            int sum = 0;
            for(int i = 0; i < coinsLimit; i++){
                sum = sum + piles.get(index).get(i);
                take = Math.max(take, sum + count(index-1, piles, k-(i+1), dp));
            }
            dp[index][k] = Math.max(notTake, take);
            return Math.max(notTake, take);
        }
    }
}
