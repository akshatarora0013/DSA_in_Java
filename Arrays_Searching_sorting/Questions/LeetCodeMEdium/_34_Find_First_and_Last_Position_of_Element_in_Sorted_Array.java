package Arrays_Searching_sorting.Questions.LeetCodeMEdium;

//  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int first = -1;
            int last = -1;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == target){
                    first = i;
                    break;
                }
            }
            for(int i = nums.length-1; i >= 0; i--){
                if(nums[i] == target){
                    last = i;
                    break;
                }
            }
            return new int[] {first, last};
        }
    }
}
