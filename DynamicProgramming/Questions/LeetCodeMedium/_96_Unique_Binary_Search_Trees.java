package DynamicProgramming.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/unique-binary-search-trees/description/

public class _96_Unique_Binary_Search_Trees {
    // Memoization
//    class Solution{
//        public int numTrees(int n) {
//            int[] dp = new int[n+1];
//            return count(n, dp);
//        }
//        private int count(int n, int[] dp){
//            if (n <= 1){
//                return 1;
//            }
//            if (dp[n] > 0){
//                return dp[n];
//            }
//            for (int i = 1; i <= n; i++) {
//                dp[n] += count(i - 1, dp) * count(n - i, dp);
//            }
//
//            return dp[n];
//        }
//    }

    // Tabulation
    class Solution{
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i <=n; i++){
                int left = 0;
                int right = i-1;
                while(left <= i-1){
                    dp[i] += dp[left] * dp[right];
                    left++;
                    right--;
                }
            }
            return dp[n];
        }
    }
}
