package Arrays.Questions.LeetCodeHard;

//  https://leetcode.com/problems/median-of-two-sorted-arrays/description/

public class _4_Median_of_Two_Sorted_Arrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] merged = new int[nums1.length + nums2.length];
            int i = 0;
            int j = 0;
            int k = 0;
            while(i < nums1.length || j < nums2.length){
                if(i < nums1.length && j < nums2.length){
                    if(nums1[i] < nums2[j]){
                        merged[k] = nums1[i];
                        i++;
                        k++;
                    }
                    else{
                        merged[k] = nums2[j];
                        j++;
                        k++;
                    }
                }
                else if(i < nums1.length){
                    merged[k] = nums1[i];
                    i++;
                    k++;
                }
                else if(j < nums2.length){
                    merged[k] = nums2[j];
                    j++;
                    k++;
                }
            }
            if(merged.length % 2 == 1){
                double ans = merged[merged.length/2];
                return ans;
            }
            else{
                double element1 = merged[merged.length/2];
                double element2 = merged[merged.length/2 - 1];
                return (element1+element2)/2.0;
            }
        }
    }
}
