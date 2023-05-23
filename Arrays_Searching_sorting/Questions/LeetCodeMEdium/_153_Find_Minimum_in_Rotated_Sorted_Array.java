package Arrays_Searching_sorting.Questions.LeetCodeMEdium;

//  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class _153_Find_Minimum_in_Rotated_Sorted_Array {
    class Solution {
        public int findMin(int[] nums) {
            int pivot = findPivot(nums);
            if(pivot == nums.length-1){
                return nums[0];
            }
            return nums[pivot+1];
        }
        private int findPivot(int[] array){
            int start = 0;
            int end = array.length - 1;
            while (start <= end){
                int mid = start + (end-start)/2;
                if (mid < end && array[mid] > array[mid+1]){
                    return mid;
                }
                else if (mid > start && array[mid] < array[mid - 1]){
                    return mid-1;
                }
                else if (array[start] >= array[mid]){
                    end = mid - 1;
                }
                else if (array[start] < array[mid]){
                    start = mid + 1;
                }
            }
            return -1;
        }
    }
}
