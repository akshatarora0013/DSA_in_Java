package Strings.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/

public class _1662_Check_If_Two_String_Arrays_are_Equivalent {
    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();

            for(String str: word1){
                s1.append(str);
            }
            for(String str: word2){
                s2.append(str);
            }
            return s1.compareTo(s2) == 0;
        }
    }
}
