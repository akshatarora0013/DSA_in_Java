package DynamicProgramming.Questions.LeetCodeMedium;

import java.util.*;

//  https://leetcode.com/problems/house-robber/description/

public class _198_House_Robber {
    //  Memoization
//    class Solution {
//        public int rob(int[] nums) {
//            int[]dp = new int[nums.length];
//            Arrays.fill(dp, -1);
//            return maxMoney(nums.length-1, nums, dp);
//        }
//        private int maxMoney(int index, int[] nums, int[] dp){
//            if(index == 0){
//                return nums[0];
//            }
//            if(index < 0){
//                return 0;
//            }
//            if(dp[index] != -1){
//                return dp[index];
//            }
//            int pick = nums[index] + maxMoney(index-2, nums, dp);
//            int notPick =  maxMoney(index-1, nums, dp);
//            dp[index] = Math.max(pick, notPick);
//            return Math.max(pick, notPick);
//        }
//    }

    // Tabulation
//    class Solution{
//        public int rob(int[] nums){
//            int[]dp = new int[nums.length];
//            dp[0] = nums[0];
//            for(int i = 1; i < nums.length; i++){
//                int take = nums[i];
//                if(i>1){
//                    take = take + dp[i-2];
//                }
//                int notTake = dp[i-1];
//                dp[i] = Math.max(take, notTake);
//            }
//            return dp[nums.length-1];
//        }
//    }

    //  Space Optimised tabulation
    class Solution{
        public int rob(int[] nums){
            int prev = nums[0];
            int prev1 = 0;
            for(int i = 1; i < nums.length; i++){
                int take = nums[i];
                if(i>1){
                    take = take + prev1;
                }
                int notTake = prev;
                prev1 = prev;
                prev = Math.max(take, notTake);
            }
            return prev;
        }
    }
}
