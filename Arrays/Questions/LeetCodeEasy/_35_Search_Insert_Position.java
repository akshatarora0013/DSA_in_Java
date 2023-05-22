package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/search-insert-position/

public class _35_Search_Insert_Position {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[mid] == target){
                    return mid;
                }
                else if(nums[mid] < target){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            return start;
        }
    }
}
