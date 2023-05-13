package DynamicProgramming.Questions.LeetCodeMedium;
//  https://leetcode.com/problems/solving-questions-with-brainpower/description/

public class _2140_Solving_Questions_With_Brainpower {
    // Memoization
//    class Solution {
//        public long mostPoints(int[][] questions) {
//            long[] dp = new long[questions.length];
//            Arrays.fill(dp, -1);
//            return maximize(0, questions, dp);
//        }
//        private long maximize(int index, int[][] questions, long[] dp){
//            if(index >= questions.length){
//                return 0;
//            }
//            if(dp[index] != -1){
//                return dp[index];
//            }
//            long take = maximize(index + questions[index][1] + 1, questions, dp) + questions[index][0];
//            long notTake = maximize(index+1, questions, dp);
//            dp[index] = Math.max(take, notTake);
//            return dp[index];
//        }
//    }

    // Tabulation
    class Solution {
        public long mostPoints(int[][] questions) {
            long[] dp = new long[questions.length+1];
            for(int index = questions.length-1; index >= 0; index--){
                long take = questions[index][0];
                if(index + questions[index][1] + 1 < questions.length){
                    take += dp[index+questions[index][1]+1];
                }
                long notTake = dp[index+1];
                dp[index] = Math.max(take, notTake);
            }
            return dp[0];
        }
    }
}
