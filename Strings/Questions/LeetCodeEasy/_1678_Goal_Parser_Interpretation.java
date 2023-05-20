package Strings.Questions.LeetCodeEasy;
import java.util.*;

//   https://leetcode.com/problems/goal-parser-interpretation/description/

public class _1678_Goal_Parser_Interpretation {
    class Solution {
        public String interpret(String command) {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < command.length(); i++){
                if(command.charAt(i) == 'G'){
                    str.append("G");
                }
                else if(command.charAt(i) == '('){
                    if(command.charAt(i+1) == 'a'){
                        str.append("al");
                    }
                    if(command.charAt(i+1) == ')'){
                        str.append("o");
                    }
                }
            }
            return str.toString();
        }
    }
}
