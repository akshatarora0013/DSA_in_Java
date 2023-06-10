package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//   https://leetcode.com/problems/minimum-absolute-difference/description/

public class _1200_Minimum_Absolute_Difference {
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            List<List<Integer>> result = new ArrayList<>();
            int diff = Integer.MAX_VALUE;
            for(int i = 0; i < arr.length-1; i++){
                int curr = arr[i+1]-arr[i];
                if(curr < diff){
                    result.clear();
                    List temp = Arrays.asList(arr[i],arr[i+1]);
                    result.add(temp);
                    diff = curr;
                }
                else if(curr == diff){
                    List temp = Arrays.asList(arr[i],arr[i+1]);
                    result.add(temp);
                }
            }
            return result;
        }
    }
}
