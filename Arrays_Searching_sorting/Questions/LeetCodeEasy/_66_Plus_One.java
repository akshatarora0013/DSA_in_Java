package Arrays_Searching_sorting.Questions.LeetCodeEasy;

//   https://leetcode.com/problems/plus-one/

public class _66_Plus_One {
    class Solution {
        public int[] plusOne(int[] digits) {
            for(int i=digits.length-1; i>=0; i--){
                if(digits[i] < 9){
                    digits[i] = digits[i] + 1;
                    return digits;
                }
                else{
                    digits[i] = 0;

                }
            }
            int arr1[] = new int[digits.length+1];
            arr1[0]=1;
            return arr1;
        }
    }
}
