package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/split-two-strings-to-make-palindrome/description/

public class _1616_Split_Two_Strings_to_Make_Palindrome {
    class Solution {
        public boolean checkPalindromeFormation(String a, String b) {
            return split(a, b) || split(b, a);
        }
        private boolean split(String a, String b){
            int left = 0;
            int right = a.length()-1;
            while(left < right && a.charAt(left) == b.charAt(right)){
                left++;
                right--;
            }
            if(left >= right){
                return true;
            }
            return isPalindrome(a, left, right) || isPalindrome(b, left, right);
        }
        private boolean isPalindrome(String str, int i, int j){
            while(i < j){
                if(str.charAt(i++) != str.charAt(j--)){
                    return false;
                }
            }
            return true;
        }
    }
}
