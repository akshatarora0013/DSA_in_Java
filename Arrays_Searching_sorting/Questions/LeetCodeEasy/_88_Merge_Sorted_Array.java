package Arrays_Searching_sorting.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/merge-sorted-array/

public class _88_Merge_Sorted_Array {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for(int i = m; i < m+n; i++){
                nums1[i] = nums2[i-m];
            }
            mergesort(nums1 , 0 , nums1.length);
        }
        static void mergesort(int[] arr, int start, int end){
            if(end - start == 1){
                return;
            }
            int mid = start + (end - start)/2;
            mergesort(arr , start , mid);
            mergesort(arr , mid , end);

            merge(arr , start , mid , end);
        }
        static void merge(int[] arr , int start , int mid , int end){
            int[] newarr = new int[end-start];
            int i = start;
            int j = mid;
            int k = 0;
            while(i < mid && j < end){
                if(arr[i] <= arr[j]){
                    newarr[k] = arr[i];
                    i++;
                    k++;
                }
                else{
                    newarr[k] = arr[j];
                    j++;
                    k++;
                }
            }
            while(i < mid){
                newarr[k] = arr[i];
                i++;
                k++;
            }
            while(j < end){
                newarr[k] = arr[j];
                j++;
                k++;
            }
            for (int l = 0; l < newarr.length; l++) {
                arr[start + l] = newarr[l];
            }
        }
    }
}
