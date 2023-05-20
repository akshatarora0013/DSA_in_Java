package Strings.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/reverse-prefix-of-word/description/

public class _2000_Reverse_Prefix_of_Word {
    class Solution {
        public String reversePrefix(String word, char ch) {
            StringBuilder str = new StringBuilder();
            int index = word.indexOf(ch);
            str.append(word.substring(0 , index+1));
            str.reverse();
            str.append(word.substring(index+1, word.length()));
            return str.toString();
        }
    }
}
