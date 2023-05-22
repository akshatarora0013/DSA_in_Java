package Arrays.Questions.LeetCodeMEdium;

//  https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

public class _81_Search_in_Rotated_Sorted_Array_II {
    class Solution {
        public boolean search(int[] nums, int target) {
            int start=0;
            int end=nums.length-1;

            while(start<=end){
                int mid= start+(end-start) /2;
                if(nums[mid]==target){
                    return true;
                }
                if(nums[start] < nums[mid]){
                    if(target < nums[mid] && target>=nums[start]){
                        end=mid-1;
                    }
                    else{
                        start=mid+1;
                    }
                }
                else if(nums[start] > nums[mid]){
                    if(target > nums[mid] && target <= nums[end]){
                        start=mid+1;
                    }
                    else{
                        end=mid-1;
                    }
                }
                else{
                    start++;
                }
            }
            return false;
        }
    }
}
