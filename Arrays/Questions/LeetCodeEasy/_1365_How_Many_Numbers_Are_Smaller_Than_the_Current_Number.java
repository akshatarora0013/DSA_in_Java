package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

public class _1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {
    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] ans = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                int count = 0;
                for(int j = 0; j < nums.length; j++){
                    if(nums[j] < nums[i]){
                        count++;
                    }
                }
                ans[i] = count;
            }
            return ans;
        }
    }
}
