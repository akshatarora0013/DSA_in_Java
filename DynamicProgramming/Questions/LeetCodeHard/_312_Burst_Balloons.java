package DynamicProgramming.Questions.LeetCodeHard;

//   https://leetcode.com/problems/burst-balloons/submissions/948260482/

public class _312_Burst_Balloons {
    // Memoization
//    class Solution {
//        public int maxCoins(int[] nums) {
//            int[] arr = new int[nums.length+2];
//            arr[0] = 1;
//            arr[arr.length-1] = 1;
//            for(int i = 0; i < nums.length; i++){
//                arr[i+1] = nums[i];
//            }
//            int[][] dp = new int[nums.length+1][nums.length+1];
//            for(int[] a: dp){
//                Arrays.fill(a, -1);
//            }
//            return maximize(1, nums.length, arr, dp);
//        }
//        private int maximize(int i, int j, int[] arr, int[][] dp){
//            if(i > j){
//                return 0;
//            }
//            if(dp[i][j] != -1){
//                return dp[i][j];
//            }
//            int max = Integer.MIN_VALUE;
//            for(int k = i; k <= j; k++){
//                int cost = arr[i-1] * arr[j+1] * arr[k] + maximize(i, k-1, arr, dp) + maximize(k+1, j, arr, dp);
//                max = Math.max(max, cost);
//            }
//            dp[i][j] = max;
//            return max;
//        }
//    }

    // Tabulation
    class Solution {
        public int maxCoins(int[] nums) {
            int[] arr = new int[nums.length+2];
            arr[0] = 1;
            arr[arr.length-1] = 1;
            for(int i = 0; i < nums.length; i++){
                arr[i+1] = nums[i];
            }
            int[][] dp = new int[nums.length+2][nums.length+2];
            for(int i = nums.length; i >= 1; i--){
                for(int j = 1; j <= nums.length; j++){
                    if(i > j){
                        continue;
                    }
                    int max = Integer.MIN_VALUE;
                    for(int k = i; k <= j; k++){
                        int cost = arr[i-1] * arr[j+1] * arr[k] + dp[i][k-1] + dp[k+1][j];
                        max = Math.max(max, cost);
                    }
                    dp[i][j] = max;
                }
            }
            return dp[1][nums.length];
        }
    }
}
