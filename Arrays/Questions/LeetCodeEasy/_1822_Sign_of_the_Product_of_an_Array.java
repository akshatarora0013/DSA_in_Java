package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/sign-of-the-product-of-an-array/description/

public class _1822_Sign_of_the_Product_of_an_Array {
    class Solution {
        public int arraySign(int[] nums) {
            int neg = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    return 0;
                }
                if(nums[i] < 0){
                    neg++;
                }
            }
            return signFunc(neg);
        }
        private int signFunc(int x){
            if(x%2 == 0){
                return 1;
            }
            return -1;
        }
    }
}
