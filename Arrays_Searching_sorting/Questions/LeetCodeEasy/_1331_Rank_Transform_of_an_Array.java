package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//   https://leetcode.com/problems/rank-transform-of-an-array/description/

public class _1331_Rank_Transform_of_an_Array {
    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            if(arr.length == 0){
                return arr;
            }
            int[] rankedArray = arr.clone();
            Map<Integer, Integer> map = new HashMap<>();
            Arrays.sort(arr);
            int rank = 1;
            int prev = arr[0];
            for(int num: arr){
                if(prev != num){
                    rank++;
                }
                map.putIfAbsent(num, rank);
                prev = num;
            }
            for(int i = 0; i < arr.length; i++){
                rankedArray[i] = map.get(rankedArray[i]);
            }
            return rankedArray;
        }
    }
}
