package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//   https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

public class _1502_Can_Make_Arithmetic_Progression_From_Sequence {
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            Arrays.sort(arr);
            for(int i = 1; i < arr.length-1; i++){
                if(arr[i]-arr[i-1] != arr[i+1] - arr[i]){
                    return false;
                }
            }
            return true;
        }
    }
}
