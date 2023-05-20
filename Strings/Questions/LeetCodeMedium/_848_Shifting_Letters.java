package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/shifting-letters/description/

public class _848_Shifting_Letters {
    class Solution {
        public String shiftingLetters(String s, int[] shifts) {
            char[] arr = s.toCharArray();
            int shift = 0;
            int i = s.length()-1;
            while(i >= 0){
                shift += shifts[i] % 26;
                arr[i] = (char)((arr[i]-'a' + shift)%26+'a');
                i--;
            }
            return String.valueOf(arr);
        }
    }
}
