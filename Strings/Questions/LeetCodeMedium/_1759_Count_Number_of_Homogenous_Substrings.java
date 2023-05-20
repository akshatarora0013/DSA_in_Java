package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/count-number-of-homogenous-substrings/description/

public class _1759_Count_Number_of_Homogenous_Substrings {
    class Solution {
        private static int mod = 1_000_000_007;
        public int countHomogenous(String s) {
            int i = 0;
            int j = 0;
            long ans = 0;
            while(j < s.length()){
                while(j < s.length() && s.charAt(i) == s.charAt(j)){
                    ans += j-i+1;
                    j++;
                }
                i = j;
            }
            return (int)(ans % mod);
        }
    }
}
