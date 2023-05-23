package Arrays_Searching_sorting.Questions.LeetCodeHard;
import java.util.*;

//  https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/

public class _315_Count_of_Smaller_Numbers_After_Self {
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            int len = nums.length;
            List<Integer> ans = new ArrayList<Integer>();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(int num: nums) {
                arr.add(num);
            }
            Collections.sort(arr);
            for(int i = 0; i<len; i++){
                int index = binarySearch(arr,nums[i]);
                ans.add(index);
                arr.remove(index);
            }
            return ans;
        }

        int binarySearch(List<Integer> arr, int target){
            int start = 0;
            int end = arr.size()-1;
            int mid=0;
            int res=0;
            while(start<=end){
                mid = start + ((end - start)/2);
                int val = arr.get(mid);
                if(val<target) start = mid + 1;
                else if(val==target)
                {
                    end=mid-1;
                    res=mid;
                }
                else end = mid - 1;
            }
            return res;
        }
    }

}
