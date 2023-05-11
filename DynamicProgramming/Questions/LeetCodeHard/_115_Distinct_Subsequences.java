package DynamicProgramming.Questions.LeetCodeHard;

import java.util.*;

//  https://leetcode.com/problems/distinct-subsequences/description/

public class _115_Distinct_Subsequences {
    // Memoization
    class Solution {
        public int numDistinct(String s, String t) {
            int[][] dp = new int[s.length()][t.length()];
            for(int[] arr: dp){
                Arrays.fill(arr, -1);
            }
            return count(s.length()-1, t.length()-1, s, t, dp);
        }
        private int count(int sIndex, int tIndex, String s, String t, int[][] dp){
            if(tIndex < 0){
                return 1;
            }
            if(sIndex < 0){
                return 0;
            }
            if(dp[sIndex][tIndex] != -1){
                return dp[sIndex][tIndex];
            }
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                dp[sIndex][tIndex] = count(sIndex-1, tIndex-1, s, t, dp) + count(sIndex-1, tIndex, s, t, dp);
                return dp[sIndex][tIndex];
            }
            else{
                dp[sIndex][tIndex] = count(sIndex-1, tIndex, s, t, dp);
                return dp[sIndex][tIndex];
            }
        }
    }

    // Tabulation
//    class Solution {
//        public int numDistinct(String s, String t) {
//            int[][] dp = new int[s.length()+1][t.length()+1];
//            for(int i = 0; i <= s.length(); i++){
//                dp[i][0] = 1;
//            }
//            for(int i = 1; i <= t.length(); i++){
//                dp[0][i] = 0;
//            }
//            for(int sIndex = 1; sIndex <= s.length(); sIndex++){
//                for(int tIndex = 1; tIndex <= t.length(); tIndex++){
//                    if(s.charAt(sIndex-1) == t.charAt(tIndex-1)){
//                        dp[sIndex][tIndex] = dp[sIndex-1][tIndex-1] + dp[sIndex-1][tIndex];
//                    }
//                    else{
//                        dp[sIndex][tIndex] = dp[sIndex-1][tIndex];
//                    }
//                }
//            }
//            return dp[s.length()][t.length()];
//        }
//    }
}
