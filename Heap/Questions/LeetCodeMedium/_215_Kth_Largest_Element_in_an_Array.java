package Heap.Questions.LeetCodeMedium;

import java.util.*;

//  https://leetcode.com/problems/kth-largest-element-in-an-array/description/

public class _215_Kth_Largest_Element_in_an_Array {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int i = 0; i < nums.length; i++){
                queue.add(nums[i]);
            }
            for(int i = 0; i < nums.length-k; i++){
                queue.remove();
            }
            return queue.peek();


            // Arrays.sort(nums);
            // return nums[nums.length-k];
        }
    }
}
