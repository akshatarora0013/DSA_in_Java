package Arrays.Questions.LeetCodeHard;

//  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/

public class _154_Find_Minimum_in_Rotated_Sorted_Array_II {
    class Solution {
        public int findMin(int[] nums) {
            if(nums.length == 1){
                return nums[0];
            }
            int pivot = findPivot(nums);
            return nums[pivot];
        }
        private int findPivot(int[] nums){

            int start = 0;
            int end = nums.length-1;
            while(start < end){
                int mid = start + (end-start)/2;
                if(nums[mid] > nums[end]){
                    start = mid+1;
                }
                else if(nums[mid] < nums[end]){
                    end = mid;
                }
                else{
                    end--;
                }
            }
            return end;
        }
    }
}
