package Arrays_Searching_sorting.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/find-the-highest-altitude/

public class _1732_Find_the_Highest_Altitude {
    class Solution {
        public int largestAltitude(int[] gain) {
            int[] arr = new int[gain.length + 1];
            arr[0] = 0;
            for(int i = 1; i < arr.length; i++){
                arr[i] = gain[i-1] + arr[i-1];
            }
            int max = arr[0];
            for(int i = 1; i < arr.length; i++){
                if(arr[i] > max){
                    max = arr[i];
                }
            }
            return max;
        }
    }
}
