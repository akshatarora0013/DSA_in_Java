package Strings.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/maximum-repeating-substring/description/

public class _1668_Maximum_Repeating_Substring {
    class Solution {
        public int maxRepeating(String sequence, String word) {
            String str = "";
            while(sequence.contains(str)){
                str = str + word;
            }
            return (str.length()-word.length())/word.length();
        }
    }
}
