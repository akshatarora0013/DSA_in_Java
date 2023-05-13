package StackAndQueues.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

public class _921_Minimum_Add_to_Make_Parentheses_Valid {
    class Solution {
        public int minAddToMakeValid(String s) {
            Stack<Character> stack = new Stack<>();
            int count = 0;
            for(char ch : s.toCharArray()){
                if(ch == '('){
                    stack.push(ch);
                }
                if(ch == ')'){
                    if(stack.empty()){
                        count++;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            while(!stack.empty()){
                stack.pop();
                count++;
            }
            return count;
        }
    }
}
