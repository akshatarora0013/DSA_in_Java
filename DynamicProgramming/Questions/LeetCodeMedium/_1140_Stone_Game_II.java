package DynamicProgramming.Questions.LeetCodeMedium;
import java.util.*;

//   https://leetcode.com/problems/stone-game-ii/
public class _1140_Stone_Game_II {
    class Solution {
        public int stoneGameII(int[] piles) {
            int[] suffix = new int[piles.length];
            suffix[suffix.length-1] = piles[piles.length-1];
            for(int i = piles.length-2; i >= 0; i--){
                suffix[i] = suffix[i+1] + piles[i];
            }
            int[][] dp = new int[piles.length][piles.length];
            for(int[] arr: dp){
                Arrays.fill(arr, -1);
            }
            return helper(piles, 0, 1, suffix, dp);
        }
        private int helper(int[] piles, int i, int M, int[] suffix, int[][]dp){
            if(i >= piles.length){
                return 0;
            }
            if(i + 2*M >= piles.length){
                return suffix[i];
            }
            if(dp[i][M] != -1){
                return dp[i][M];
            }
            int result = 0;
            for(int x = 1; x <= 2*M; x++){
                result = Math.max(result, suffix[i] - helper(piles, i+x, Math.max(M, x), suffix, dp));
            }
            dp[i][M] = result;
            return dp[i][M];
        }
    }
}
