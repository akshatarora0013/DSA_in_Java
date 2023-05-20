package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/number-of-substrings-with-only-1s/description/

public class _1513_Number_of_Substrings_With_Only_1s {
    class Solution {
        private static int mod = 1_000_000_007;
        public int numSub(String s) {
            int i = 0;
            int j = 0;
            long ans = 0;
            while(j < s.length()){
                if(s.charAt(j) == '0'){
                    i = j+1;
                    j++;
                }
                else{
                    ans += j-i+1;
                    j++;
                }
            }
            return (int)(ans%mod);
        }
    }
}
