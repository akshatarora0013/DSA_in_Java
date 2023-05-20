package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/shuffle-the-array/description/

public class _1470_Shuffle_the_Array {
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] ans = new int[nums.length];
            int i = 0;
            int k = 0;
            while(i < n){
                ans[k++] = nums[i];
                ans[k++] = nums[i+n];
                i++;
            }
            return ans;
        }
    }
}
