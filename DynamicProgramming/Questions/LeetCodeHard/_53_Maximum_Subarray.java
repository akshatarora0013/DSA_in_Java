package DynamicProgramming.Questions.LeetCodeHard;

//  https://leetcode.com/problems/maximum-subarray/description/

public class _53_Maximum_Subarray {
    // Tabulation
    class Solution {
        int maxSum;
        public int maxSubArray(int[] nums) {
            maxSum = nums[0];
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                dp[i] = nums[i];
                if(dp[i-1] > 0){
                    dp[i] = dp[i] + dp[i-1];
                }
                maxSum = Math.max(maxSum, dp[i]);
            }
            return maxSum;
        }
    }
}
