package Arrays_Searching_sorting.Questions.LeetCodeMEdium;

import java.util.*;

//   https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/

public class _1498_Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition {
    class Solution {
        int mod = 1_000_000_007;
        public int numSubseq(int[] nums, int target) {
            int count = 0;
            Arrays.sort(nums);
            int[] power = new int[nums.length];
            power[0] = 1;
            for(int i = 1; i < power.length; i++){
                power[i] = (power[i-1] * 2) % mod;
            }
            int left = 0;
            int right = nums.length-1;
            while(left <= right){
                if(nums[left] + nums[right] <= target){
                    count = count + power[right-left];
                    count = count % mod;
                    left++;
                }
                else{
                    right--;
                }
            }
            return count;
        }
    }
}
