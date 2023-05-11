package DynamicProgramming.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/uncrossed-lines/description/

public class _1035_Uncrossed_lines {
    // Memoization
//    class Solution {
//    public int maxUncrossedLines(int[] nums1, int[] nums2) {
//        int[][] dp = new int[nums1.length][nums2.length];
//        for(int[] arr: dp){
//            Arrays.fill(arr, -1);
//        }
//        return count(0, nums1, nums2, 0, dp);
//    }
//    private int count(int index1, int[] nums1, int[] nums2, int index2, int[][] dp){
//        if(index1 == nums1.length || nums2.length == index2){
//            return 0;
//        }
//        if(dp[index1][index2] != -1){
//            return dp[index1][index2];
//        }
//        int take = 0;
//        int notTake = 0;
//        if(nums1[index1] == nums2[index2]){
//            take = count(index1+1, nums1, nums2, index2+1, dp) + 1;
//        }
//        else{
//            notTake = Math.max(count(index1+1, nums1, nums2, index2, dp), count(index1, nums1, nums2, index2+1, dp));
//        }
//        dp[index1][index2] = Math.max(take, notTake);
//        return dp[index1][index2];
//    }
//}

    // Tabulation
    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int[][] dp = new int[nums1.length+1][nums2.length+1];
            for(int index = nums1.length-1; index >= 0; index--){
                for(int last = nums2.length-1; last >= 0; last--){
                    int take = 0;
                    int notTake = 0;
                    if(nums1[index] == nums2[last]){
                        take = 1 + dp[index+1][last+1];
                    }
                    else{
                        notTake = Math.max(dp[index+1][last], dp[index][last+1]);
                    }
                    dp[index][last] = Math.max(take, notTake);
                }
            }
            return dp[0][0];
        }
    }
}
