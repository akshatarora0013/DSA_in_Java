package DynamicProgramming.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/jump-game/description/

public class _55_Jump_Game {
//    brute force

//    class Solution {
//        public boolean canJump(int[] nums) {
//            int[] dp = new int[nums.length];
//            Arrays.fill(dp, -1);
//            int ans = check(0, dp, nums);
//            if(ans == 0){
//                return false;
//            }
//            return true;
//        }
//        private int check(int index, int[] dp, int[] nums){
//            if(index >= nums.length-1){
//                return 1;
//            }
//            if(nums[index] == 0){
//                return 0;
//            }
//            if(dp[index] != -1){
//                return dp[index];
//            }
//            int result = 0;
//            for(int i = 1; i <= nums[index]; i++){
//                result = result | check(index+i, dp, nums);
//                if(result == 1){
//                    dp[index] = 1;
//                    return result;
//                }
//            }
//            dp[index] = result;
//            return result;
//        }
//    }

    class Solution {
        public boolean canJump(int[] nums) {
            int reachable = 0;
            for(int i = 0; i < nums.length; i++){
                if(i > reachable){
                    return false;
                }
                reachable = Math.max(reachable, i+nums[i]);
            }
            return true;
        }
    }
}
