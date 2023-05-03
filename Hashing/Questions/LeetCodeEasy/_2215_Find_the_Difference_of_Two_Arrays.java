package Hashing.Questions.LeetCodeEasy;

import java.util.*;

//  https://leetcode.com/problems/find-the-difference-of-two-arrays/description/

public class _2215_Find_the_Difference_of_Two_Arrays {
    class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            return Arrays.asList(getDistinctElements(nums1, nums2), getDistinctElements(nums2, nums1));
        }
        private List<Integer> getDistinctElements(int[] nums1, int[] nums2){
            Set<Integer> distinct = new HashSet<>();

            for(int num: nums1){
                boolean unique = true;
                for(int x: nums2){
                    if(num == x){
                        unique = false;
                        break;
                    }
                }
                if(unique){
                    distinct.add(num);
                }
            }
            return new ArrayList<>(distinct);
        }
    }
}
