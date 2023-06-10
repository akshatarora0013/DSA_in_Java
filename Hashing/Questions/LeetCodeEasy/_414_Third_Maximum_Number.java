package Hashing.Questions.LeetCodeEasy;
import java.util.*;

//   https://leetcode.com/problems/third-maximum-number/description/

public class _414_Third_Maximum_Number {
    class Solution {
        public int thirdMax(int[] nums) {
            Set<Integer> set = new TreeSet<>();
            for(int i = 0; i < nums.length; i++){
                set.add(nums[i]);
            }
            List<Integer> list = new ArrayList<>();
            list.addAll(set);
            if(list.size() < 3){
                return list.get(list.size()-1);
            }
            return list.get(list.size() - 3);
        }
    }
}
