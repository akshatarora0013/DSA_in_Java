package Strings.Questions.LeetCodeEasy;
import java.util.*;

//   https://leetcode.com/problems/longest-common-prefix/description/

public class _14_Longest_Common_Prefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            Arrays.sort(strs);
            StringBuilder str = new StringBuilder();
            char[] first = strs[0].toCharArray();
            char[] last = strs[strs.length-1].toCharArray();

            for(int i = 0; i < first.length; i++){
                if(first[i] != last[i]){
                    break;
                }
                str.append(first[i]);
            }
            return str.toString();
        }
    }
}
