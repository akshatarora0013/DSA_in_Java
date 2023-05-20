package DynamicProgramming.Questions.LeetCodeHard;
import java.util.*;

//  https://leetcode.com/problems/maximize-score-after-n-operations/submissions/950017679/

public class _1799_Maximize_Score_After_N_Operations {
    class Solution {
        public int maxScore(int[] nums) {
            int dpSize = 1 << nums.length;
            int[] dp = new int[dpSize];
            Arrays.fill(dp, -1);
            return maximize(nums, 0, 1, dp);
        }
        private int maximize(int[] nums, int mask, int operation, int[] dp){
            if(2 * operation > nums.length){
                return 0;
            }
            if(dp[mask] != -1){
                return dp[mask];
            }
            for(int firstIndex = 0; firstIndex < nums.length; firstIndex++){
                if((mask & (1<<firstIndex)) != 0){
                    continue;
                }
                for(int secondIndex = firstIndex+1; secondIndex < nums.length; secondIndex++){
                    if((mask & (1<<secondIndex)) != 0){
                        continue;
                    }
                    int newMask = (1 << firstIndex) | (1 << secondIndex) | mask;
                    int score = operation * gcd(nums[firstIndex], nums[secondIndex]) + maximize(nums, newMask, operation+1, dp);
                    dp[mask] = Math.max(dp[mask], score);
                }
            }
            return dp[mask];
        }
        private int gcd(int a , int b){
            if(a == 0){
                return b;
            }
            return gcd(b%a , a);
        }
    }
}
