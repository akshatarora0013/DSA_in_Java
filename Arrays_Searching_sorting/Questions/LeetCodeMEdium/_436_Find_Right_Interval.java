package Arrays_Searching_sorting.Questions.LeetCodeMEdium;
import java.util.*;

//  https://leetcode.com/problems/find-right-interval/description/

public class _436_Find_Right_Interval {
    class Solution {
        public int[] findRightInterval(int[][] intervals) {
            Map<Integer, Integer> map = new HashMap<>();
            int j = 0;
            for(int[] arr: intervals){
                map.put(arr[0], j++);
            }
            Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
            int[] ans = new int[intervals.length];
            for(int i = 0; i < ans.length; i++){
                int index = map.get(intervals[i][0]);
                int array[] = binarySearch(intervals, intervals[i][1]);
                if(array == null){
                    ans[index] = -1;
                }
                else{
                    ans[index] = map.get(array[0]);
                }
            }
            return ans;
        }
        private int[] binarySearch(int[][] intervals, int k){
            int[] ans = null;
            int start = 0;
            int end = intervals.length-1;
            while(start <= end){
                int mid = start + (end-start)/2;
                if(intervals[mid][0] >= k){
                    ans = intervals[mid];
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            return ans;
        }
    }
}
