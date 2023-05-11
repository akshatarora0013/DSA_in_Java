package DynamicProgramming.Questions.LeetCodeMedium;

import java.util.*;

//  https://leetcode.com/problems/jump-game-ii/description/

public class _45_Jump_Game_II {
    //  Memoization
//    class Solution {
//        public int jump(int[] nums) {
//            int[] dp = new int[nums.length];
//            Arrays.fill(dp, -1);
//            return count(0, nums, dp);
//        }
//        private int count(int index, int[] nums, int[] dp){
//            if(index == nums.length-1){
//                return 0;
//            }
//            if(dp[index] != -1){
//                return dp[index];
//            }
//            int min = 10000000;
//            for(int i = index+1; i <= index + nums[index] && i < nums.length; i++){
//                min = Math.min(min, count(i, nums, dp)+1);
//            }
//            dp[index] = min;
//            return min;
//        }
//    }

    // Tabulation
    class Solution {
        public int jump(int[] nums) {
            int[] dp = new int[nums.length];
            dp[nums.length-1] = 0;
            for(int index = nums.length-2; index >= 0; index--){
                int min = 10000000;
                for(int i = index+1; i <= index + nums[index] && i < nums.length; i++){
                    min = Math.min(min,dp[i]+1);
                }
                dp[index] = min;
            }
            return dp[0];
        }
    }
}
