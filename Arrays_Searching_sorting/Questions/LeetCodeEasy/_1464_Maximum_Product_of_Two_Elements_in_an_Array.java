package Arrays_Searching_sorting.Questions.LeetCodeEasy;

//   https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

public class _1464_Maximum_Product_of_Two_Elements_in_an_Array {
    class Solution {
        public int maxProduct(int[] nums) {
            int max = 0;
            for(int i = 0; i < nums.length-1; i++){
                for(int j = i+1; j < nums.length; j++){
                    int pro = (nums[i]-1) * (nums[j]-1);
                    if(pro > max){
                        max = pro;
                    }
                }
            }
            return max;
        }
    }
}
