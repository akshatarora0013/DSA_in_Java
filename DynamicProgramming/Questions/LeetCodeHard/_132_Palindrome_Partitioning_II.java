package DynamicProgramming.Questions.LeetCodeHard;
import java.util.*;

//  https://leetcode.com/problems/palindrome-partitioning-ii/description/

public class _132_Palindrome_Partitioning_II {
    //  Memoization
//    class Solution {
//        public int minCut(String str) {
//            int n = str.length();
//            int[] dp = new int[n];
//            Arrays.fill(dp, -1);
//            return minimize(0, n, str, dp) - 1;
//        }
//        private int minimize(int i, int n, String str, int[] dp){
//            if(i == n){
//                return 0;
//            }
//            if(dp[i] != -1){
//                return dp[i];
//            }
//            int minCost = Integer.MAX_VALUE;
//            for(int j = i; j < n; j++){
//                if(isPalindrome(i, j, str)){
//                    int cost = 1 + minimize(j+1, n, str, dp);
//                    minCost = Math.min(minCost, cost);
//                }
//            }
//            dp[i] = minCost;
//            return minCost;
//        }
//        private boolean isPalindrome(int i, int j, String str){
//            while(i < j){
//                if(str.charAt(i) != str.charAt(j)){
//                    return false;
//                }
//                i++;
//                j--;
//            }
//            return true;
//        }
//    }

    // Tabulation
    class Solution {
        public int minCut(String str) {
            int n = str.length();
            int[] dp = new int[n+1];
            for(int i = n-1; i >= 0; i--){
                int minCost = Integer.MAX_VALUE;
                for(int j = i; j < n; j++){
                    if(isPalindrome(i, j, str)){
                        int cost = 1 + dp[j+1];
                        minCost = Math.min(minCost, cost);
                    }
                }
                dp[i] = minCost;
            }
            return dp[0] - 1;
        }
        private boolean isPalindrome(int i, int j, String str){
            while(i < j){
                if(str.charAt(i) != str.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}
