package Arrays_Searching_sorting.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

public class _1295_Find_Numbers_with_Even_Number_of_Digits {
    class Solution {
        public int findNumbers(int[] nums) {
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                int digits = 0;
                while(nums[i] != 0){
                    nums[i] = nums[i]/10;
                    digits++;
                }
                if(digits%2 == 0){
                    count++;
                }
            }
            return count;
        }
    }
}
