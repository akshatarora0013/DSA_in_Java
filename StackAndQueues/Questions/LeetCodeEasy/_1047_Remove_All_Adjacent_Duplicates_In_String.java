package StackAndQueues.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

public class _1047_Remove_All_Adjacent_Duplicates_In_String {
    class Solution {
        public String removeDuplicates(String s) {
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++){
                if(stack.isEmpty()){
                    stack.push(s.charAt(i));
                }
                else if(stack.peek() != s.charAt(i)){
                    stack.push(s.charAt(i));
                }
                else if(stack.peek() == s.charAt(i)){
                    stack.pop();
                }
            }
            StringBuilder sb = new StringBuilder("");
            while(!stack.isEmpty()){
                sb.insert(0 , stack.pop());
            }
            return sb.toString();
        }
    }
}
