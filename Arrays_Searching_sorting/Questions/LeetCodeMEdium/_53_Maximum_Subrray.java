package Arrays_Searching_sorting.Questions.LeetCodeMEdium;

public class _53_Maximum_Subrray {
    // kedane's Algo
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                sum = sum + nums[i];
                if(sum > max){
                    max = sum;
                }
                if(sum < 0){
                    sum = 0;
                }
            }
            return max;
        }
    }

    // Divide and conqueor
//    class Solution {
//        public int maxSubArray(int[] nums) {
//            return maximize(0, nums.length-1, nums);
//        }
//        private int maximize(int start, int end, int[] nums){
//            if(start == end){
//                return nums[start];
//            }
//            int leftArraySum = Integer.MIN_VALUE;
//            int rightArraySum = Integer.MIN_VALUE;
//            int mid = start + (end - start)/2;
//            int currSum = 0;
//            for(int i = mid; i >= start; i--){
//                currSum = currSum + nums[i];
//                leftArraySum = Math.max(leftArraySum, currSum);
//            }
//            currSum = 0;
//            for(int i = mid+1; i <= end; i++){
//                currSum = currSum + nums[i];
//                rightArraySum = Math.max(currSum, rightArraySum);
//            }
//
//            int css = leftArraySum + rightArraySum;
//            int lss = maximize(start, mid, nums);
//            int rss = maximize(mid+1, end, nums);
//
//            return Math.max(css, Math.max(lss, rss));
//        }
//    }
}
