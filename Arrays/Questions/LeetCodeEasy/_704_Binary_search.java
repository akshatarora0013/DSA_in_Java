package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/binary-search/

public class _704_Binary_search {
    class Solution {
        public int search(int[] arr, int target) {
            int start = 0;
            int end = arr.length - 1;
            while(start <= end){
                int mid = end + (start - end)/2;
                if(arr[mid] == target){
                    return mid;
                }
                else if(arr[mid] < target){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            return -1;
        }
    }
}
