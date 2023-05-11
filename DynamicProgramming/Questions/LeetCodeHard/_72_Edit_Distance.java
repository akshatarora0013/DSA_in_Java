package DynamicProgramming.Questions.LeetCodeHard;

import java.util.*;

//  https://leetcode.com/problems/edit-distance/description/

public class _72_Edit_Distance {
    //  Memoization
    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length()][word2.length()];
            for(int[] arr: dp){
                Arrays.fill(arr, -1);
            }
            return count(word1.length()-1, word2.length()-1, word1, word2, dp);
        }
        private int count(int w1Index, int w2Index, String word1, String word2, int[][] dp){
            if(w1Index < 0){
                return w2Index + 1;
            }
            if(w2Index < 0){
                return w1Index + 1;
            }
            if(dp[w1Index][w2Index] != -1){
                return dp[w1Index][w2Index];
            }
            if(word1.charAt(w1Index) == word2.charAt(w2Index)){
                dp[w1Index][w2Index] = count(w1Index-1, w2Index-1, word1, word2, dp);
                return dp[w1Index][w2Index];
            }
            int insert = count(w1Index, w2Index-1, word1, word2, dp) + 1;
            int delete = count(w1Index-1, w2Index, word1, word2, dp) + 1;
            int replace = count(w1Index-1, w2Index-1, word1, word2,dp) + 1;
            dp[w1Index][w2Index] = Math.min(insert, Math.min(delete, replace));
            return dp[w1Index][w2Index];
        }
    }

    //  Tabulation
//    class Solution {
//        public int minDistance(String word1, String word2) {
//            int[][] dp = new int[word1.length()+1][word2.length()+1];
//            for(int i = 0; i <= word2.length(); i++){
//                dp[0][i] = i;
//            }
//            for(int i = 0; i <= word1.length(); i++){
//                dp[i][0] = i;
//            }
//            for(int w1Index = 1; w1Index <= word1.length(); w1Index++){
//                for(int w2Index = 1; w2Index <= word2.length(); w2Index++){
//                    if(word1.charAt(w1Index-1) == word2.charAt(w2Index-1)){
//                        dp[w1Index][w2Index] = dp[w1Index-1][w2Index-1];
//                    }
//                    else{
//                        int insert = dp[w1Index][w2Index-1] + 1;
//                        int delete = dp[w1Index-1][w2Index] + 1;
//                        int replace = dp[w1Index-1][w2Index-1] + 1;
//                        dp[w1Index][w2Index] = Math.min(insert, Math.min(delete, replace));
//                    }
//                }
//            }
//            return dp[word1.length()][word2.length()];
//        }
//    }
}
