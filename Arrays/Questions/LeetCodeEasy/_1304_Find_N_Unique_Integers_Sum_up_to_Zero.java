package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

public class _1304_Find_N_Unique_Integers_Sum_up_to_Zero {
    class Solution {
        public int[] sumZero(int n) {
            int[] arr = new int[n];
            for(int i = 1; i < n; i+=2){
                arr[i] = 0+i;
                arr[i-1] = -(arr[i]);
            }
            return arr;
        }
    }
}
