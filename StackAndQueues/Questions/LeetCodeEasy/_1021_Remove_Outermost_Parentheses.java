package StackAndQueues.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/remove-outermost-parentheses/

public class _1021_Remove_Outermost_Parentheses {
    class Solution {
        public String removeOuterParentheses(String s) {
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '('){
                    if(!stack.isEmpty()){
                        sb.append(s.charAt(i));
                    }
                    stack.push(s.charAt(i));
                }
                else{
                    stack.pop();
                    if(!stack.isEmpty()){
                        sb.append(s.charAt(i));
                    }
                }
            }

            return sb.toString();
        }
    }
}
