package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/swap-adjacent-in-lr-string/description/

public class _777_Swap_Adjacent_in_LR_String {
    class Solution {
        public boolean canTransform(String start, String end) {
            int i = 0;
            int j = 0;
            char[] s = start.toCharArray();
            char[] e = end.toCharArray();
            while(i < s.length || j < e.length){
                while(i < s.length && s[i] == 'X'){
                    i++;
                }
                while(j < s.length && e[j] == 'X'){
                    j++;
                }
                if(i >= s.length || j >= e.length){
                    break;
                }
                if(s[i] != e[j] || (s[i] == 'R' && i > j) || (s[i] == 'L' && i < j)){
                    return false;
                }
                i++;
                j++;
            }
            return i==j;
        }
    }
}
