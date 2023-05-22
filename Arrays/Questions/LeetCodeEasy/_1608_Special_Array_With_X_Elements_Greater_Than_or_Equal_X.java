package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

public class _1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X {
    class Solution {
        public int specialArray(int[] nums) {
            for(int i = 0; i <= nums.length; i++){
                int count = 0;
                for(int j = 0; j < nums.length; j++){
                    if(nums[j] >= i){
                        count++;
                    }
                }
                if(count == i){
                    return i;
                }
            }
            return -1;
        }
    }
}
