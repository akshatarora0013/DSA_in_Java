package Arrays_Searching_sorting.Questions.LeetCodeEasy;

//   https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            result[0] = searchFirst(nums, target);
            result[1] = searchLast(nums, target);

            return result;
        }

        private int searchFirst(int[] nums, int target){
            int start = 0;
            int end = nums.length-1;
            int index = -1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[mid] == target){
                    index = mid;
                    end = mid-1;
                }
                else if(nums[mid] < target){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            return index;
        }

        private int searchLast(int[] nums, int target){
            int start = 0;
            int end = nums.length-1;
            int index = -1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[mid] == target){
                    index = mid;
                    start = mid+1;
                }
                else if(nums[mid] < target){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            return index;
        }
    }
}
