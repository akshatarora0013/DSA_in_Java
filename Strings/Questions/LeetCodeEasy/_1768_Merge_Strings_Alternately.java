package Strings.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/merge-strings-alternately/description/

public class _1768_Merge_Strings_Alternately {
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder str = new StringBuilder();
            int i = 0;
            while(i < word1.length() || i < word2.length()){
                if(i < word1.length()){
                    str.append(word1.charAt(i));
                }
                if(i < word2.length()){
                    str.append(word2.charAt(i));
                }
                i++;
            }
            return str.toString();
        }
    }
}
