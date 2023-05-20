package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/number-of-good-pairs/

public class _1512_Number_of_Good_Pairs {
    class Solution {
        public int numIdenticalPairs(int[] nums) {
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                for(int j = i+1; j < nums.length; j++){
                    if((nums[i] ^ nums[j]) == 0){
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
