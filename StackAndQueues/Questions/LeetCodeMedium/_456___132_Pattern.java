package StackAndQueues.Questions.LeetCodeMedium;
import java.util.*;

//   https://leetcode.com/problems/132-pattern/description/

public class _456___132_Pattern {
    class Solution {
        public boolean find132pattern(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int thirdElement = Integer.MIN_VALUE;
            for(int i = nums.length-1; i >= 0; i--){
                if(nums[i] < thirdElement){
                    return true;
                }
                while(!stack.isEmpty() && stack.peek() < nums[i]){
                    thirdElement = stack.pop();
                }
                stack.push(nums[i]);
            }
            return false;
        }
    }
}
