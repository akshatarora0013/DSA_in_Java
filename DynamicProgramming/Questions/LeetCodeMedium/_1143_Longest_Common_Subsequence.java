package DynamicProgramming.Questions.LeetCodeMedium;

//   https://leetcode.com/problems/longest-common-subsequence/description/

public class _1143_Longest_Common_Subsequence {
    // Memoizatrion
//    class Solution {
//    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
//        for(int[] arr: dp){
//            Arrays.fill(arr, -1);
//        }
//        return count(text1.length(), text2.length(), text1, text2, dp);
//    }
//    private int count(int index1, int index2, String text1, String text2, int[][] dp){
//        if(index1 == 0 || index2 == 0){
//            return 0;
//        }
//        if(dp[index1][index2] != -1){
//            return dp[index1][index2];
//        }
//        if(text1.charAt(index1-1) == text2.charAt(index2-1)){
//            dp[index1][index2] = count(index1-1, index2-1, text1, text2, dp) + 1;
//            return dp[index1][index2];
//        }
//        int case1 = count(index1-1, index2, text1, text2, dp);
//        int case2 = count(index1, index2-1, text1, text2, dp);
//        dp[index1][index2] = Math.max(case1, case2);
//        return Math.max(case1, case2);
//    }
//}

    // Tabulation
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            for(int i = 0; i < dp[0].length; i++){
                dp[0][i] = 0;
            }
            for(int i = 0; i < dp.length; i++){
                dp[i][0] = 0;
            }
            for(int index1 = 1; index1 <= text1.length(); index1++){
                for(int index2 = 1; index2 <= text2.length(); index2++){
                    if(text1.charAt(index1-1) == text2.charAt(index2-1)){
                        dp[index1][index2] = dp[index1-1][index2-1] + 1;
                    }
                    else{
                        int case1 = dp[index1-1][index2];
                        int case2 = dp[index1][index2-1];
                        dp[index1][index2] = Math.max(case1, case2);
                    }
                }
            }
            return dp[text1.length()][text2.length()];
        }
    }
}
