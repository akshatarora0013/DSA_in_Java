package Arrays_Searching_sorting.Questions.LeetCodeHard;

//   https://leetcode.com/problems/find-in-mountain-array/

public class _1095_Find_in_Mountain_Array {
//    class Solution {
//        public int findInMountainArray(int target, MountainArray array) {
//            int peak = peakelement(array);
//            int ans = search(array , target , 0 , peak);
//            if (ans == -1){
//                ans = search(array , target , peak+1 , array.length() - 1);
//            }
//            return ans;
//        }
//        private int peakelement(MountainArray array){
//            int start = 0;
//            int end = array.length() - 1;
//            while (start < end){
//                int mid = start + (end-start)/2;
//                if (array.get(mid) > array.get(mid+1)){
//                    end = mid;
//                }
//                else {
//                    start = mid + 1;
//                }
//            }
//            return start;
//        }
//        private int search(MountainArray array , int target , int start , int end){
//            boolean isAsc = array.get(start) < array.get(end);
//            while (start <= end){
//                int mid = start + (end-start)/2;
//                if (array.get(mid) == target){
//                    return mid;
//                }
//                if (isAsc){
//                    if (target>array.get(mid)){
//                        start = mid + 1;
//                    }
//                    else {
//                        end = mid - 1;
//                    }
//                }
//                else {
//                    if (target>array.get(mid)){
//                        end = mid - 1;
//                    }
//                    else {
//                        start = mid + 1;
//                    }
//                }
//            }
//            return -1;
//        }
//    }
}
