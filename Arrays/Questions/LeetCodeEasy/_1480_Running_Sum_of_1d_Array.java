package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/running-sum-of-1d-array/

public class _1480_Running_Sum_of_1d_Array {
    class Solution {
        public int[] runningSum(int[] nums) {
            int[] runningSum = new int[nums.length];
            runningSum[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                runningSum[i] = runningSum[i-1] + nums[i];
            }
            return runningSum;
        }
    }
}
