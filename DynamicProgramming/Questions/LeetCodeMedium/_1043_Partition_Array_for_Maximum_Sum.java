package DynamicProgramming.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/partition-array-for-maximum-sum/description/

public class _1043_Partition_Array_for_Maximum_Sum {
    // Memoization
//    class Solution {
//        public int maxSumAfterPartitioning(int[] arr, int k) {
//            int[] dp = new int[arr.length];
//            Arrays.fill(dp, -1);
//            return maximize(0, k, arr, dp);
//        }
//        private int maximize(int i, int k, int[] arr, int[] dp){
//            if(i == arr.length){
//                return 0;
//            }
//            if(dp[i] != -1){
//                return dp[i];
//            }
//            int len = 0;
//            int maxIndex = Integer.MIN_VALUE;
//            int max = Integer.MIN_VALUE;
//            for(int j = i; j < Math.min(arr.length, i+k); j++){
//                len++;
//                maxIndex = Math.max(maxIndex, arr[j]);
//                int sum = len*maxIndex + maximize(j+1, k, arr, dp);
//                max = Math.max(sum, max);
//            }
//            dp[i] = max;
//            return max;
//        }
//    }

    // Tabulation
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int[] dp = new int[arr.length+1];
            for(int i = arr.length-1; i >= 0; i--){
                int len = 0;
                int maxIndex = Integer.MIN_VALUE;
                int max = Integer.MIN_VALUE;
                for(int j = i; j < Math.min(arr.length, i+k); j++){
                    len++;
                    maxIndex = Math.max(maxIndex, arr[j]);
                    int sum = len*maxIndex + dp[j+1];
                    max = Math.max(sum, max);
                }
                dp[i] = max;
            }
            return dp[0];
        }
    }
}
