package Arrays_Searching_sorting.Questions.LeetCodeMEdium;

//  https://leetcode.com/problems/product-of-array-except-self/description/

public class _238_Product_of_Array_Except_Self {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] prefix = new int[nums.length];
            int[] suffix = new int[nums.length];
            prefix[0] = 1;
            for(int i = 1; i < nums.length; i++){
                prefix[i] = prefix[i-1] * nums[i-1];
            }
            suffix[nums.length-1] = 1;
            for(int i = nums.length-2; i >= 0; i--){
                suffix[i] = suffix[i+1] * nums[i+1];
            }
            int[] ans = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                ans[i] = prefix[i] * suffix[i];
            }
            return ans;
        }
    }
}
