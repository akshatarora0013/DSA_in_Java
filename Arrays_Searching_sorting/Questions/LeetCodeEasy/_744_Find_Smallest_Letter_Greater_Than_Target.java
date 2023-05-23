package Arrays_Searching_sorting.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/find-smallest-letter-greater-than-target/

public class _744_Find_Smallest_Letter_Greater_Than_Target {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int start = 0;
            int end = letters.length - 1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(letters[mid] <= target){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            return letters[start%letters.length];
        }
    }
}
