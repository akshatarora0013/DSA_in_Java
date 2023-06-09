package StackAndQueues.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/find-the-most-competitive-subsequence/description/

public class _1673_Find_the_Most_Competitive_Subsequence {
    class Solution {
        public int[] mostCompetitive(int[] nums, int k) {
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < nums.length; i++){
                while(!stack.isEmpty() && stack.peek() > nums[i] && nums.length-i > k - stack.size()){
                    stack.pop();
                }
                if(stack.size() < k){
                    stack.push(nums[i]);
                }
            }
            int[] ans = new int[k];
            for(int i = k-1; i >= 0; i--){
                ans[i] = stack.pop();
            }
            return ans;
        }
    }
}
