package Arrays.Questions.LeetCodeMEdium;

//  https://leetcode.com/problems/find-the-duplicate-number/description/

public class _287_Find_the_Duplicate_Number {
    class Solution {
        public int findDuplicate(int[] nums) {
            int[] count = new int[nums.length+1];
            for(int i = 0; i < nums.length; i++){
                count[nums[i]]++;
            }
            for(int i = 0; i < nums.length; i++){
                if(count[i] >= 2){
                    return i;
                }
            }
            return -1;
        }
    }
}
