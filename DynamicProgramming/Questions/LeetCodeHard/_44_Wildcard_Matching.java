package DynamicProgramming.Questions.LeetCodeHard;

import java.util.*;

//  https://leetcode.com/problems/wildcard-matching/description/

public class _44_Wildcard_Matching {
    // Memoization
    class Solution {
        public boolean isMatch(String s, String p) {
            Boolean[][] dp = new Boolean[s.length()][p.length()];
            return check(s.length()-1, p.length()-1, s, p, dp);
        }
        private boolean check(int sIndex, int pIndex, String s, String p, Boolean[][] dp){
            if(sIndex < 0 && pIndex < 0){
                return true;
            }
            if(pIndex < 0 && sIndex >= 0){
                return false;
            }
            if(sIndex < 0 && pIndex >= 0){
                for(int i = 0; i <= pIndex; i++){
                    if(p.charAt(i) != '*'){
                        return false;
                    }
                }
                return true;
            }
            if(dp[sIndex][pIndex] != null){
                return dp[sIndex][pIndex];
            }
            if(s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?'){
                dp[sIndex][pIndex] = check(sIndex-1, pIndex-1, s, p, dp);
                return dp[sIndex][pIndex];
            }
            if(p.charAt(pIndex) == '*'){
                dp[sIndex][pIndex] = check(sIndex, pIndex-1, s, p, dp) || check(sIndex-1 ,pIndex, s, p, dp);
                return dp[sIndex][pIndex];
            }
            return false;
        }
    }
}
