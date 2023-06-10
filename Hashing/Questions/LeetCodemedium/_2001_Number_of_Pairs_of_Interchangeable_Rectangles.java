package Hashing.Questions.LeetCodemedium;
import java.util.*;

//  https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/description/

public class _2001_Number_of_Pairs_of_Interchangeable_Rectangles {
    class Solution {
        public long interchangeableRectangles(int[][] rectangles) {
            long count = 0;
            Map<Double, Long> freq = new HashMap<>();
            for(int i = 0; i < rectangles.length; i++){
                double temp = (double)rectangles[i][0]/rectangles[i][1];
                freq.put(temp, freq.getOrDefault(temp, (long)0)+1);
            }
            for(Map.Entry<Double, Long> entry: freq.entrySet()){
                long temp = (entry.getValue() - 1);
                count += temp*(temp+1)/2;
            }
            return count;
        }
    }
}
