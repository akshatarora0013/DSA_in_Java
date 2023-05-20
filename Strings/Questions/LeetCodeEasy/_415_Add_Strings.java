package Strings.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/add-strings/description/

public class _415_Add_Strings {
    class Solution {
        public String addStrings(String num1, String num2) {
            int carry = 0;
            StringBuilder ans = new StringBuilder();
            int i = num1.length()-1;
            int j = num2.length()-1;
            while(i >= 0 || j >= 0){
                int a = 0, b = 0;
                if(i >= 0){
                    a = num1.charAt(i) - '0';
                }
                if(j >= 0){
                    b = num2.charAt(j) - '0';
                }
                int sum = carry + a + b;
                carry = sum/10;
                ans.append(sum%10);
                i--;
                j--;
            }
            if(carry != 0){
                ans.append(carry);
            }
            return ans.reverse().toString();
        }
    }
}
