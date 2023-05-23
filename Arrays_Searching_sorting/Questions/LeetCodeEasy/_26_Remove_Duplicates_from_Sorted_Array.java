package Arrays_Searching_sorting.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

public class _26_Remove_Duplicates_from_Sorted_Array {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[i] != nums[j]){
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i+1;
        }
    }
}
