package Strings.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/valid-palindrome-ii/description/

public class _680_Valid_Palindrome_II {
    class Solution {
        public boolean validPalindrome(String s) {
            int i = 0;
            int j = s.length()-1;
            while(i < j){
                if(s.charAt(i) != s.charAt(j)){
                    return palindromeCheck(s, i, j-1) || palindromeCheck(s, i+1, j);
                }
                i++;
                j--;
            }
            return true;
        }
        private boolean palindromeCheck(String s, int i, int j){
            while(i < j){
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}
