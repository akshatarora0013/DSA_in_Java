package Arrays_Searching_sorting.Questions.LeetCodeMEdium;

//  https://leetcode.com/problems/sort-colors/description/

public class _75_Sort_Colors {
    class Solution {
        public void sortColors(int[] nums) {
            for(int i = 0; i < nums.length; i++){
                for(int j = 0; j < nums.length -i-1; j++){
                    if(nums[j] > nums[j+1]){
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    }
                }
            }
        }
    }
}
