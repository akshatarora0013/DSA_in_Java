package Arrays.Questions.LeetCodeEasy;
import java.util.*;

//   https://leetcode.com/problems/intersection-of-two-arrays/description/

public class _349_Intersection_of_Two_Arrays {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            ArrayList<Integer> list = new ArrayList<>();
            int prev = -1;
            for(int i = 0; i < nums1.length; i++){
                int common = search(nums2, nums1[i]);
                if(common > prev){
                    list.add(common);
                    prev = common;
                }
            }
            int[] arr = new int[list.size()];
            for(int i = 0; i < arr.length; i++){
                arr[i] = list.get(i);
            }
            return arr;
        }
        private int search(int[] arr, int target){
            int start = 0;
            int end = arr.length-1;
            while(start <= end){
                int mid = start + (end-start)/2;
                if(arr[mid] == target){
                    return target;
                }
                else if(arr[mid] < target){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            return -1;
        }
    }
}
