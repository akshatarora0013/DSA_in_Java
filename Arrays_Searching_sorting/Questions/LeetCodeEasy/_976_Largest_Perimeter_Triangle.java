package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//   https://leetcode.com/problems/largest-perimeter-triangle/description/

public class _976_Largest_Perimeter_Triangle {
    class Solution {
        public int largestPerimeter(int[] A) {
            Arrays.sort(A);
            for (int i = A.length - 3; i >= 0; --i){
                if (A[i] + A[i+1] > A[i+2]){
                    return A[i] + A[i+1] + A[i+2];
                }
            }
            return 0;
        }
    }
}
