package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/concatenation-of-array/

public class _1929_Concatenation_of_Array {
    class Solution {
        public int[] getConcatenation(int[] nums) {
            int[] ans = new int[2*(nums.length)];
            int i = 0;
            while(i < nums.length){
                ans[i] = nums[i];
                ans[i + (nums.length)] = nums[i];
                i++;
            }
            return ans;
        }
    }
}
