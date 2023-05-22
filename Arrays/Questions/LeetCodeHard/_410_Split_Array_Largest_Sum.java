package Arrays.Questions.LeetCodeHard;

//   https://leetcode.com/problems/split-array-largest-sum/

public class _410_Split_Array_Largest_Sum {
    class Solution {
        public int splitArray(int[] nums, int k) {
            int start = 0;
            int end = 0;
            for(int i = 0; i < nums.length; i++){
                start = Math.max(start , nums[i]);
                end = end + nums[i];
            }
            while(start < end){
                int mid = start + (end - start)/2;
                int partitions = 1;
                int sum = 0;
                for(int i = 0; i < nums.length; i++){
                    if(sum + nums[i] > mid){
                        sum = nums[i];
                        partitions++;
                    }
                    else{
                        sum = sum + nums[i];
                    }
                }
                if(partitions <= k){
                    end = mid;
                }
                else{
                    start = mid + 1;
                }
            }
            return end;
        }
    }
}
