package Strings.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/roman-to-integer/description/

public class _13_Roman_to_Integer {
    class Solution {
        public int romanToInt(String s) {
            int ans = 0;
            int num = 0;
            int prev = 0;
            for(int i = s.length()-1; i >= 0; i--){
                switch(s.charAt(i)){
                    case 'I': num = 1; break;
                    case 'V': num = 5; break;
                    case 'X': num = 10; break;
                    case 'L': num = 50; break;
                    case 'C': num = 100; break;
                    case 'D': num = 500; break;
                    case 'M': num = 1000; break;
                }
                if(num < prev){
                    ans -= num;
                }
                else{
                    ans += num;
                }
                prev = num;
            }
            return ans;
        }
    }
}
