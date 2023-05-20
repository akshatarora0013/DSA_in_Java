package Strings.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

public class _557_Reverse_Words_in_a_String_III {
    class Solution {
        public String reverseWords(String s) {
            String[] words = s.split(" ");
            StringBuilder sentence = new StringBuilder();
            for(int j = 0; j < words.length; j++){
                String word = words[j];
                StringBuilder str = new StringBuilder();
                for(int i = word.length()-1; i >= 0; i--){
                    str.append(word.charAt(i));
                }
                sentence.append(str);
                if(j != words.length-1){
                    sentence.append(" ");
                }
            }
            return sentence.toString();
        }
    }
}
