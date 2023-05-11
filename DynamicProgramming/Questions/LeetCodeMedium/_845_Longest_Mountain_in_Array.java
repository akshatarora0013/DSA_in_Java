package DynamicProgramming.Questions.LeetCodeMedium;
import java.util.*;

//   https://leetcode.com/problems/longest-mountain-in-array/description/

public class _845_Longest_Mountain_in_Array {
    class Solution {
        public int longestMountain(int[] nums) {
            int[] dpForward = new int[nums.length];
            Arrays.fill(dpForward, 1);
            for(int i = 1; i < nums.length; i++){
                if(nums[i] > nums[i-1]){
                    dpForward[i] = 1 + dpForward[i-1];
                }
            }
            int[] dpBackward = new int[nums.length];
            Arrays.fill(dpBackward, 1);
            for (int i = nums.length-2; i >= 0; i--) {
                if (nums[i] > nums[i+1]) {
                    dpBackward[i] = 1 + dpBackward[i+1];
                }
            }
            int max = 0;
            for(int i = 0; i < nums.length; i++){
                if (dpForward[i] > 1 && dpBackward[i] > 1) {
                    max = Math.max(max, dpForward[i] + dpBackward[i] - 1);
                }
            }
            return max;
        }
    }
}
