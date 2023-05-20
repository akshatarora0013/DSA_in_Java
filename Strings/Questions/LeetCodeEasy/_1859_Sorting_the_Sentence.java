package Strings.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/sorting-the-sentence/description/

public class _1859_Sorting_the_Sentence {
    class Solution {
        public String sortSentence(String s) {
            String[] words = s.split(" ");
            String[] res = new String[words.length];
            StringBuilder str = new StringBuilder();
            for(String element: words){
                int i = (int)(element.charAt(element.length()-1) - '0');
                res[i-1] = element.substring(0, element.length()-1);
            }
            for(int i = 0; i < res.length; i++){
                if(i == res.length-1){
                    str.append(res[i]);
                    continue;
                }
                str.append(res[i] + " ");
            }
            return str.toString();
        }
    }
}
