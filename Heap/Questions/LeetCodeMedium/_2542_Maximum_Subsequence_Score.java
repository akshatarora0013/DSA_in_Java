package Heap.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/maximum-subsequence-score/description/

public class _2542_Maximum_Subsequence_Score {
    class Solution {
        public long maxScore(int[] nums1, int[] nums2, int k) {
            int[][] pair = new int[nums1.length][2];
            for(int i = 0; i < nums1.length; i++){
                pair[i][0] = nums2[i];
                pair[i][1] = nums1[i];
            }
            Arrays.sort(pair, (a,b) -> b[0]-a[0]);

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            long currSum = 0;
            for(int i = 0; i < k-1; i++){
                pq.add(pair[i][1]);
                currSum += pair[i][1];
            }

            long ans = 0;
            for(int i = k-1; i < nums1.length; i++){
                currSum += pair[i][1];
                ans = Math.max(ans, (long)currSum*pair[i][0]);

                if(pq.size() > 0 && pq.peek() < pair[i][1]){
                    currSum -= pq.remove();
                    pq.add(pair[i][1]);
                }
                else{
                    currSum -= pair[i][1];
                }
            }

            return ans;
        }
    }
}
