package Strings.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/description/

public class _1967_Number_of_Strings_That_Appear_as_Substrings_in_Word {
    class Solution {
        public int numOfStrings(String[] patterns, String word) {
            int count = 0;
            for(String str: patterns){
                if(word.indexOf(str) >= 0){
                    count++;
                }
            }
            return count;
        }
    }
}
