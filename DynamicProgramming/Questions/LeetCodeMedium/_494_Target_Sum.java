package DynamicProgramming.Questions.LeetCodeMedium;

import java.util.*;

//  https://leetcode.com/problems/target-sum/description/

public class _494_Target_Sum {
    class Solution {
        int total;
        public int findTargetSumWays(int[] nums, int target) {
            total = 0;
            for(int i = 0; i < nums.length; i++){
                total = total + nums[i];
            }
            int[][] dp = new int[nums.length][2*total+1];
            for(int[] arr: dp){
                Arrays.fill(arr, Integer.MIN_VALUE);
            }
            return count(0, 0, target, nums, dp);
        }
        private int count(int index,int sum, int target, int[] nums, int[][] dp){
            if(index == nums.length){
                if(sum == target){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            if(dp[index][total + sum] != Integer.MIN_VALUE){
                return dp[index][total + sum];
            }
            int case1 = count(index+1, sum+nums[index], target, nums, dp);
            int case2 = count(index+1, sum-nums[index], target, nums, dp);
            dp[index][total + sum] = case1+case2;
            return case1 + case2;
        }
    }


}
