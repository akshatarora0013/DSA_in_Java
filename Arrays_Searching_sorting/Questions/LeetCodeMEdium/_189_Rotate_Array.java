package Arrays_Searching_sorting.Questions.LeetCodeMEdium;

//  https://leetcode.com/problems/rotate-array/description/

public class _189_Rotate_Array {
    class Solution {
        public void rotate(int[] nums, int k) {
            k = k%nums.length;
            reverse(nums, 0, nums.length-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, nums.length-1);
        }
        private void reverse(int[] nums, int start, int end){
            while(end > start){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}
