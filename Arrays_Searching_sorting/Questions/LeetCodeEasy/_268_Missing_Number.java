package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/missing-number/

public class _268_Missing_Number {
    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != i){
                    return i;
                }
            }
            return nums.length;
        }
    }
}
