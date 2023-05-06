package Heap.Questions.LeetCodeHard;

import java.util.*;

//   https://leetcode.com/problems/median-of-two-sorted-arrays/description/

public class _4_Median_of_Two_Sorted_Arrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int i = 0; i < nums1.length; i++){
                queue.add(nums1[i]);
            }
            for(int j = 0; j < nums2.length; j++){
                queue.add(nums2[j]);
            }
            int size = queue.size();
            while(queue.size() != (size/2)+1){
                queue.remove();
            }
            if(size%2 == 0){
                double num1 = (double)queue.remove();
                double num2 = (double)queue.remove();
                return (num1+num2)/2;
            }
            return (double)queue.remove();
        }
    }
}
