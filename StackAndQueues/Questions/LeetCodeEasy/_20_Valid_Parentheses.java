package StackAndQueues.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/valid-parentheses/

public class _20_Valid_Parentheses {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                }
                else if(ch == ')' || ch == '}' || ch == ']') {
                    if (ch == ')') {
                        if (stack.isEmpty() || stack.pop() != '(') {
                            return false;
                        }
                    }
                    if (ch == '}') {
                        if (stack.isEmpty() || stack.pop() != '{') {
                            return false;
                        }
                    }
                    if (ch == ']') {
                        if (stack.isEmpty() || stack.pop() != '[') {
                            return false;
                        }
                    }
                }
                else{
                    continue;
                }
            }
            return stack.isEmpty();
        }
    }
}
