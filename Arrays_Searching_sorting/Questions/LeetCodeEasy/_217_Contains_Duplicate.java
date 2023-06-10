package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/contains-duplicate/

public class _217_Contains_Duplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for(int i = 1; i < nums.length; i++){
                if(nums[i] == nums[i-1]){
                    return true;
                }
            }
            return false;
        }
    }
}
