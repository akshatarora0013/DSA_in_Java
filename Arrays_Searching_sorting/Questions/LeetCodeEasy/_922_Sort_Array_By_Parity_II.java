package Arrays_Searching_sorting.Questions.LeetCodeEasy;
//  https://leetcode.com/problems/sort-array-by-parity-ii/

public class _922_Sort_Array_By_Parity_II {
    class Solution {
        public int[] sortArrayByParityII(int[] nums) {
            int[] arr = new int[nums.length];
            int i = 0;
            int j = 1;
            for(int k = 0; k < nums.length; k++){
                if(nums[k] % 2 == 0){
                    arr[i] = nums[k];
                    i = i+2;
                }
                else{
                    arr[j] = nums[k];
                    j = j+2;
                }
            }
            return arr;
        }
    }
}
