package DynamicProgramming.Questions.LeetCodeHard;

import java.util.*;

//  https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

public class _1312_Minimum_Insertion_Steps_to_Make_a_String_Palindrome {
    class Solution {
        public int minInsertions(String s1) {
            char ch;
            String s2 = "";
            for (int i = 0; i < s1.length(); i++){
                ch= s1.charAt(i);
                s2= ch + s2;
            }
            int maxlcp = lcs(s1, s2);
            return s1.length() - maxlcp;
        }
        public int lcs(String s1, String s2){
            int n=s1.length();
            int m=s2.length();

            int dp[][]=new int[n+1][m+1];
            for(int rows[]:dp)
                Arrays.fill(rows,-1);
            for(int i=0;i<=n;i++){
                dp[i][0] = 0;
            }
            for(int i=0;i<=m;i++){
                dp[0][i] = 0;
            }
            for(int ind1=1;ind1<=n;ind1++){
                for(int ind2=1;ind2<=m;ind2++){
                    if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                        dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                    else
                        dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
            return dp[n][m];
        }
    }
}
