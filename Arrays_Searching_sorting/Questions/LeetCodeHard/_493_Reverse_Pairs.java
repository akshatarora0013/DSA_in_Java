package Arrays_Searching_sorting.Questions.LeetCodeHard;
import java.util.*;

//   https://leetcode.com/problems/reverse-pairs/description/

public class _493_Reverse_Pairs {
    class Solution {
        public int reversePairs(int[] nums) {
            return mergeSort(nums, 0, nums.length-1);
        }
        private int mergeSort(int[] nums, int start, int end){
            if(start >= end){
                return 0;
            }
            int mid = start + (end-start)/2;
            int ans = mergeSort(nums, start, mid);
            ans += mergeSort(nums, mid+1, end);
            ans += merge(nums, start, mid, end);
            return ans;
        }
        private int merge(int[] nums, int start, int mid, int end){
            int count = 0;
            int j = mid+1;
            for(int i = start; i <= mid; i++){
                while(j <= end && nums[i]>(2*(long)nums[j])){
                    j++;
                }
                count += j-(mid+1);
            }
            ArrayList<Integer> temp = new ArrayList<>();
            int left = start;
            int right = mid+1;
            while(left <= mid && right <= end){
                if(nums[left] >= nums[right]){
                    temp.add(nums[right++]);
                }
                else{
                    temp.add(nums[left++]);
                }
            }
            while(left <= mid){
                temp.add(nums[left++]);
            }
            while(right <= end){
                temp.add(nums[right++]);
            }
            for(int i = start; i <= end; i++){
                nums[i] = temp.get(i-start);
            }
            return count;
        }
    }
}
