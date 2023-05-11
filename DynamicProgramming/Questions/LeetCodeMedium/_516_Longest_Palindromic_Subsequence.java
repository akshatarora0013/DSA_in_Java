package DynamicProgramming.Questions.LeetCodeMedium;

import java.util.*;

//  https://leetcode.com/problems/longest-palindromic-subsequence/description/

public class _516_Longest_Palindromic_Subsequence {
    class Solution {
        public int longestPalindromeSubseq(String text1) {
            char ch;
            String text2 = "";
            for (int i = 0; i < text1.length(); i++){
                ch= text1.charAt(i);
                text2= ch + text2;
            }
            int[][] dp = new int[text1.length()][text2.length()];
            for(int[] arr: dp){
                Arrays.fill(arr, -1);
            }
            return count(text1.length()-1, text2.length()-1, text1, text2, dp);
        }
        private int count(int index1, int index2, String text1, String text2, int[][] dp){
            if(index1 < 0 || index2 < 0){
                return 0;
            }
            if(dp[index1][index2] != -1){
                return dp[index1][index2];
            }
            if(text1.charAt(index1) == text2.charAt(index2)){
                dp[index1][index2] = count(index1-1, index2-1, text1, text2, dp) + 1;
                return dp[index1][index2];
            }
            int case1 = count(index1-1, index2, text1, text2, dp);
            int case2 = count(index1, index2-1, text1, text2, dp);
            dp[index1][index2] = Math.max(case1, case2);
            return Math.max(case1, case2);
        }
    }
}
