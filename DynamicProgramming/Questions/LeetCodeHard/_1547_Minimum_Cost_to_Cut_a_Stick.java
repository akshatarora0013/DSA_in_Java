package DynamicProgramming.Questions.LeetCodeHard;
import java.util.*;

//  https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/

public class _1547_Minimum_Cost_to_Cut_a_Stick {
    // memoization
//    class Solution {
//        public int minCost(int n, int[] cuts) {
//            int[] arr = new int[cuts.length+2];
//            arr[0] = 0;
//            arr[arr.length-1] = n;
//            for(int i = 0; i < cuts.length; i++){
//                arr[i+1] = cuts[i];
//            }
//            Arrays.sort(arr);
//            int[][] dp = new int[cuts.length+1][cuts.length+1];
//            for(int[] a: dp){
//                Arrays.fill(a, -1);
//            }
//            return minimize(1, cuts.length, arr, dp);
//        }
//        private int minimize(int i, int j, int[] arr, int[][] dp){
//            if(i > j){
//                return 0;
//            }
//            if(dp[i][j] != -1){
//                return dp[i][j];
//            }
//            int min = Integer.MAX_VALUE;
//            for(int k = i; k <= j; k++){
//                int cost = arr[j+1] - arr[i-1] + minimize(i, k-1, arr, dp) + minimize(k+1, j, arr, dp);
//                min = Math.min(min, cost);
//            }
//            dp[i][j] = min;
//            return min;
//        }
//    }

    // Tabulation
    class Solution {
        public int minCost(int n, int[] cuts) {
            int[] arr = new int[cuts.length+2];
            arr[0] = 0;
            arr[arr.length-1] = n;
            for(int i = 0; i < cuts.length; i++){
                arr[i+1] = cuts[i];
            }
            Arrays.sort(arr);
            int[][] dp = new int[cuts.length+2][cuts.length+2];
            for(int i = cuts.length; i >= 1; i--){
                for(int j = 1; j <= cuts.length; j++){
                    if(i > j){
                        continue;
                    }
                    int min = Integer.MAX_VALUE;
                    for(int k = i; k <= j; k++){
                        int cost = arr[j+1] - arr[i-1] + dp[i][k-1] + dp[k+1][j];
                        min = Math.min(min, cost);
                    }
                    dp[i][j] = min;
                }
            }
            return dp[1][cuts.length];
        }
    }
}
