package Arrays.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/check-if-n-and-its-double-exist/description/

public class _1346_Check_If_N_and_Its_Double_Exist {
    class Solution {
        public boolean checkIfExist(int[] arr) {
            Arrays.sort(arr);
            for(int i = 0; i < arr.length; i++){
                int res = binarySearch(arr, arr[i]*2);
                if(res != -1 && res != i){
                    return true;
                }
            }
            return false;
        }
        private int binarySearch(int[] arr, int target){
            int start = 0;
            int end = arr.length-1;
            while(start <= end){
                int mid = start + (end-start)/2;
                if(arr[mid] == target){
                    return mid;
                }
                else if(arr[mid] > target){
                    end = mid -1;
                }
                else{
                    start = mid+1;
                }
            }
            return -1;
        }
    }
}
