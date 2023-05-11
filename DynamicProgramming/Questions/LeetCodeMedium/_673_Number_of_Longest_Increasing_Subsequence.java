package DynamicProgramming.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

public class _673_Number_of_Longest_Increasing_Subsequence {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int[] count = new int[nums.length];
            Arrays.fill(dp, 1);
            Arrays.fill(count ,1);
            int max = 0;
            for(int i = 0; i < nums.length; i++){
                for(int prev = 0; prev < i; prev++){
                    if(nums[prev] < nums[i] && 1+dp[prev] > dp[i]){
                        dp[i] = 1+dp[prev];
                        count[i] = count[prev];
                    }
                    else if(nums[prev] < nums[i] && 1+dp[prev] == dp[i]){
                        count[i] = count[i] + count[prev];
                    }
                }
                max = Math.max(max, dp[i]);
            }
            int ans = 0;
            for(int i = 0; i < nums.length; i++){
                if(dp[i] == max){
                    ans = ans + count[i];
                }
            }
            return ans;
        }
    }
}
