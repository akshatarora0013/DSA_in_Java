package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/squares-of-a-sorted-array/

public class _977_Squares_of_a_Sorted_Array {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            for(int i = 0; i < nums.length; i++){
                nums[i] = nums[i] * nums[i];
            }
            Arrays.sort(nums);
            return nums;
        }
    }
}
