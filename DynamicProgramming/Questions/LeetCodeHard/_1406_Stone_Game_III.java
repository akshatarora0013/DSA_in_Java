package DynamicProgramming.Questions.LeetCodeHard;
import java.util.*;

//  https://leetcode.com/problems/stone-game-iii/description/

public class _1406_Stone_Game_III {
    class Solution {
        public String stoneGameIII(int[] stoneValue) {
            int[] dp = new int[stoneValue.length];
            Arrays.fill(dp, Integer.MAX_VALUE);
            int result = helper(stoneValue, 0, dp);
            if(result > 0)return "Alice";
            else if(result < 0)return "Bob";
            else return "Tie";
        }
        private int helper(int[] stoneValue, int i, int[] dp){
            if(i >= stoneValue.length){
                return 0;
            }
            if(dp[i] != Integer.MAX_VALUE){
                return dp[i];
            }
            int takeone = stoneValue[i] - helper(stoneValue, i+1, dp);
            int takeTwo = Integer.MIN_VALUE;
            if(i+1 < stoneValue.length){
                takeTwo = stoneValue[i] + stoneValue[i+1] - helper(stoneValue, i+2, dp);
            }
            int takeThree = Integer.MIN_VALUE;
            if(i+2 < stoneValue.length){
                takeThree = stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - helper(stoneValue, i+3, dp);
            }
            dp[i] = Math.max(takeone, Math.max(takeTwo, takeThree));
            return dp[i];
        }
    }
}
