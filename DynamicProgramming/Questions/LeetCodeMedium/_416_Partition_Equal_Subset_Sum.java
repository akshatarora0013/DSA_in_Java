package DynamicProgramming.Questions.LeetCodeMedium;

import java.util.*;

//   https://leetcode.com/problems/partition-equal-subset-sum/description/

public class _416_Partition_Equal_Subset_Sum {
    // Memoization
//    class Solution {
//        public boolean canPartition(int[] nums) {
//            int sum = 0;
//            for(int i = 0; i < nums.length; i++){
//                sum = sum + nums[i];
//            }
//            if(sum % 2 == 1){
//                return false;
//            }
//            int target = sum/2;
//            int dp[][] = new int[nums.length][target+1];
//            for(int arr[]: dp)
//                Arrays.fill(arr, -1);
//            return check(nums.length-1, target, nums, dp);
//        }
//        private boolean check(int index, int target, int[] nums, int[][] dp){
//            if(target == 0){
//                return true;
//            }
//            if(index == 0){
//                return nums[0]==target;
//            }
//            if(dp[index][target] != -1){
//                if(dp[index][target] == 0){
//                    return false;
//                }
//                return true;
//            }
//            boolean notTake = check(index-1, target, nums, dp);
//            boolean take = false;
//            if(nums[index] <= target){
//                take = check(index-1, target-nums[index], nums, dp);
//            }
//            boolean ans = take || notTake;
//            if(ans){
//                dp[index][target] = 1;
//            }
//            else{
//                dp[index][target] = 0;
//            }
//            return ans;
//        }
//    }

    // Tabulation
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                sum = sum + nums[i];
            }
            if(sum % 2 == 1){
                return false;
            }
            int k = sum/2;
            boolean dp[][]=new boolean[nums.length][k+1];
            for(int i = 0; i < nums.length; i++){
                dp[i][0] = true;
            }
            if(nums[0] <= k){
                dp[0][nums[0]] = true;
            }
            for(int ind = 1; ind < nums.length; ind++){
                for(int target = 1; target <= k; target++){

                    boolean notTaken = dp[ind-1][target];

                    boolean taken = false;
                    if(nums[ind]<=target){
                        taken = dp[ind-1][target-nums[ind]];
                    }
                    dp[ind][target]= notTaken||taken;
                }
            }

            return dp[nums.length-1][k];
        }
    }
}
