package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/string-to-integer-atoi/description/

public class _8_String_to_Integer_atoi {
    class Solution {
        public int myAtoi(String s) {
            s = s.trim();
            if(s.length() == 0){
                return 0;
            }
            int len = s.length();
            int index = 0;
            boolean isNegative = s.charAt(index) == '-';
            boolean isPositive = s.charAt(index) == '+';
            if(isPositive || isNegative){
                index++;
            }

            double result = 0;
            while(index < len && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
                result = result * 10 + (s.charAt(index) - '0');
                index++;
            }
            if(isNegative){
                result = -result;
            }
            if(result > Integer.MAX_VALUE){
                result = Integer.MAX_VALUE;
            }
            if(result < Integer.MIN_VALUE){
                result = Integer.MIN_VALUE;
            }
            return (int)result;
        }
    }
}
