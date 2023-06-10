package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/height-checker/

public class _1051_Height_Checker {
    class Solution {
        public int heightChecker(int[] heights) {
            int count = 0;
            int[] expected = new int[heights.length];
            for(int i = 0; i < heights.length; i++){
                expected[i] = heights[i];
            }
            Arrays.sort(heights);
            for(int i = 0; i < heights.length; i++){
                if(heights[i] != expected[i]){
                    count++;
                }
            }
            return count;
        }
    }
}
