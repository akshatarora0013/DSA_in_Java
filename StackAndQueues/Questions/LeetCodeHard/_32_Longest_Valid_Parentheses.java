package StackAndQueues.Questions.LeetCodeHard;
import java.util.*;

//   https://leetcode.com/problems/longest-valid-parentheses/submissions/949451488/

public class _32_Longest_Valid_Parentheses {
    class Solution {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '('){
                    stack.push(i);
                }
                else{
                    stack.pop();
                    if(stack.isEmpty()){
                        stack.push(i);
                    }
                    else{
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
            return maxans;
        }
    }
}
