package DynamicProgramming.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/count-ways-to-build-good-strings/description/

public class _2466_Count_Ways_To_Build_Good_Strings {
    class Solution {
        int mod = 1_000_000_007;
        public int countGoodStrings(int low, int high, int zero, int one) {
            int[] dp = new int[high+1];
            Arrays.fill(dp, -1);
            dp[0] = 1;
            int ans = 0;
            for(int end = low; end <= high; end++){
                ans += count(end, zero, one, dp);
                ans %= mod;
            }
            return ans;
        }
        private int count(int end, int zero, int one, int[] dp){
            if(dp[end] != -1){
                return dp[end];
            }
            int c = 0;
            if(end >= zero){
                c += count(end-zero, zero, one, dp);
            }
            if(end >= one){
                c += count(end-one, zero, one, dp);
            }
            dp[end] = c % mod;
            return dp[end];
        }
    }
}
