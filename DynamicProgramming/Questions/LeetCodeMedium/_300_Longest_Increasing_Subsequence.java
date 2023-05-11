package DynamicProgramming.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/longest-increasing-subsequence/

public class _300_Longest_Increasing_Subsequence {
    // Memoization
//    class Solution {
//        public int lengthOfLIS(int[] nums) {
//            int[][] dp = new int[nums.length][nums.length+1];
//            for(int[] arr: dp){
//                Arrays.fill(arr, -1);
//            }
//            return count(0, -1, nums, dp);
//        }
//        private int count(int index, int prevIndex, int[] nums, int[][] dp){
//            if(index == nums.length){
//                return 0;
//            }
//            if(dp[index][prevIndex+1] != -1){
//                return dp[index][prevIndex+1];
//            }
//            int notTake = count(index+1, prevIndex, nums, dp);
//            int take = 0;
//            if(prevIndex >= 0){
//                if(nums[prevIndex] < nums[index]){
//                    take = count(index+1, index, nums, dp) + 1;
//                }
//            }
//            else{
//                take = count(index+1, index, nums, dp) + 1;
//            }
//            dp[index][prevIndex+1] = Math.max(notTake, take);
//            return Math.max(notTake, take);
//        }
//    }

    // Tabulation
//    class Solution {
//        public int lengthOfLIS(int[] nums) {
//            int[][] dp = new int[nums.length+1][nums.length+1];
//            for(int index = nums.length-1; index >= 0; index--){
//                for(int prevIndex = index - 1; prevIndex >= -1; prevIndex--){
//                    int len = dp[index+1][prevIndex+1];
//                    if(prevIndex == -1 || nums[prevIndex] < nums[index]){
//                        len = Math.max(len, dp[index+1][index+1] + 1);
//                    }
//                    dp[index][prevIndex+1] = len;
//                }
//            }
//            return dp[0][0];
//        }
//    }

    // Space optimised
//    class Solution {
//        public int lengthOfLIS(int[] nums) {
//            int[] next = new int[nums.length+1];
//            int[] curr = new int[nums.length+1];
//            for(int index = nums.length-1; index >= 0; index--){
//                for(int prevIndex = index - 1; prevIndex >= -1; prevIndex--){
//                    int len = next[prevIndex+1];
//                    if(prevIndex == -1 || nums[prevIndex] < nums[index]){
//                        len = Math.max(len, next[index+1] + 1);
//                    }
//                    curr[prevIndex+1] = len;
//                }
//                next = curr;
//            }
//            return curr[0];
//        }
//    }

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int max = 1;
            Arrays.fill(dp, 1);
            for(int i = 0; i < nums.length; i++){
                for(int prev = 0; prev < i; prev++){
                    if(nums[prev] < nums[i] && 1+dp[prev] > dp[i]){
                        dp[i] = 1+dp[prev];
                    }
                }
                if(dp[i] > max){
                    max = dp[i];
                }
            }
            return max;
        }
    }
}
