package Strings.Questions.LeetCodeMedium;

//   https://leetcode.com/problems/longest-palindromic-substring/description/

public class _5_Longest_Palindromic_Substring {
    class Solution {
        int maxLen = 0;
        int start = 0;
        public String longestPalindrome(String s) {
            char[] input = s.toCharArray();
            if(s.length() < 2){
                return s;
            }
            for(int i = 0; i < input.length; i++){
                expand(input, i, i);
                expand(input, i, i+1);
            }
            return s.substring(start, start + maxLen);
        }
        private void expand(char[] input, int i, int j){
            while(i >= 0 && j < input.length && input[i] == input[j]){
                i--;
                j++;
            }
            if(j-i-1 > maxLen){
                maxLen = j-i-1;
                start = i+1;
            }
        }
    }
}
