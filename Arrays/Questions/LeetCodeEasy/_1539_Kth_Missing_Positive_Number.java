package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/kth-missing-positive-number/

public class _1539_Kth_Missing_Positive_Number {
    class Solution {
        public int findKthPositive(int[] arr, int k) {
            if(arr[0] > k){
                return k;
            }
            int start = 0;
            int end = arr.length-1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(missing(arr[mid] , mid) < k){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            return arr[end] + k - missing(arr[end] , end);
        }
        int missing(int a , int b){
            return a-b-1;
        }
    }
}
