package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/max-consecutive-ones/description/

public class _485_Max_Consecutive_Ones {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    if(count > max){
                        max = count;
                    }
                    count = 0;
                    continue;
                }
                count++;
            }
            if(count > max){
                max = count;
            }
            return max;
        }
    }
}
