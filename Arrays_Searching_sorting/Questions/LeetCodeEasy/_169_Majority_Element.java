package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/majority-element/
public class _169_Majority_Element {
    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            int mid = nums.length/2;
            return nums[mid];
        }
    }
}
