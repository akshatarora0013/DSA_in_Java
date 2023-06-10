package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/

public class _1356_Sort_Integers_by_The_Number_of_1_Bits {
    class Solution {
        public int[] sortByBits(int[] arr) {
            for(int i = 0; i < arr.length; i++){
                arr[i] += Integer.bitCount(arr[i])*10001;
            }
            Arrays.sort(arr);
            for(int i = 0; i < arr.length; i++){
                arr[i] = arr[i] % 10001;
            }
            return arr;
        }
    }
}
