package StackAndQueues.Questions.LeetCodeMedium;
import java.util.*;

//   https://leetcode.com/problems/next-greater-element-ii/description/

public class _503_Next_Greater_Element_II {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] res = new int[nums.length];
            Stack<Integer> stack = new Stack<>();
            for(int i = 2 * nums.length-1; i >= 0; i--){
                while(!stack.isEmpty() && nums[stack.peek()] <= nums[i%nums.length]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i % nums.length] = -1;
                }
                else{
                    res[i % nums.length] = nums[stack.peek()];
                }            ;
                stack.push(i % nums.length);
            }
            return res;
        }
    }
}
