package Arrays.Questions.LeetCodeMEdium;

//  https://leetcode.com/problems/single-element-in-a-sorted-array/description/

public class _540_Single_Element_in_a_Sorted_Array {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int start = 0;
            int end = nums.length-1;
            while(start < end){
                int mid = start + (end - start)/2;
                if(mid  % 2 == 1){
                    mid--;
                }
                if(nums[mid] != nums[mid+1]){
                    end = mid;
                }
                else{
                    start = mid + 2;
                }
            }
            return nums[start];
        }
    }
}
