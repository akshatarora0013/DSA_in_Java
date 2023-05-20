package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/reverse-words-in-a-string/description/

public class _151_Reverse_Words_in_a_String {
    class Solution {
        public String reverseWords(String s) {
            s = s.replaceAll("\\s+"," ").trim();
            String[] arr = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i = arr.length-1; i >= 0; i--){
                sb.append(arr[i]);
                if(i != 0){
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
    }
}
