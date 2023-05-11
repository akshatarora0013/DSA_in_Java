package DynamicProgramming.Questions.LeetCodeHard;

import java.util.*;

//  https://leetcode.com/problems/shortest-common-supersequence/description/

public class _1092_Shortest_Common_Supersequence {
    class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {
            int n = str1.length();
            int m = str2.length();

            int dp[][] = new int[n+1][m+1];
            for(int rows[]: dp){
                Arrays.fill(rows,-1);
            }
            for(int i = 0; i <= n; i++){
                dp[i][0] = 0;
            }
            for(int i = 0; i <= m; i++){
                dp[0][i] = 0;
            }

            for(int ind1 = 1; ind1 <= n; ind1++){
                for(int ind2 = 1; ind2 <= m; ind2++){
                    if(str1.charAt(ind1-1) == str2.charAt(ind2-1)){
                        dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                    }
                    else{
                        dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                    }
                }
            }

            String ans = "";
            int i = n;
            int j = m;
            while(i > 0 && j > 0){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    ans = str1.charAt(i-1) + ans;
                    i--;
                    j--;
                }
                else if(dp[i - 1][j] > dp[i][j - 1]){
                    ans = str1.charAt(i - 1) + ans;
                    i--;
                }
                else{
                    ans = str2.charAt(j - 1) + ans;
                    j--;
                }
            }
            while(i > 0){
                ans = str1.charAt(i-1) + ans;
                i--;
            }
            while(j > 0){
                ans = str2.charAt(j-1) + ans;
                j--;
            }
            return ans;
        }
    }
}
