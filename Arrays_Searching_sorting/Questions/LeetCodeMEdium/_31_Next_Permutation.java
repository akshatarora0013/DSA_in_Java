package Arrays_Searching_sorting.Questions.LeetCodeMEdium;

//  https://leetcode.com/problems/next-permutation/description/

public class _31_Next_Permutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length-2;
            while(i >= 0 && nums[i+1] <= nums[i]){
                i--;
            }
            if(i >= 0){
                int j = nums.length-1;
                while(nums[j] <= nums[i]){
                    j--;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            reverse(nums, i+1);
        }
        private void reverse(int[] nums, int start) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
    }
}
