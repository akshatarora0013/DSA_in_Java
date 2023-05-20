package Strings.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/print-words-vertically/

public class _1324_Print_Words_Vertically {
    class Solution {
        public List<String> printVertically(String s) {
            List<String> vertical = new ArrayList<>();
            String[] words = s.split("\\s");
            int maxLength = 0;
            for(String x: words){
                if(maxLength < x.length()){
                    maxLength = x.length();
                }
            }

            for(int i = 0; i < maxLength; i++){
                StringBuilder str = new StringBuilder();
                for(int j = 0; j < words.length; j++){
                    if(i > words[j].length()-1){
                        str.append(" ");
                    }
                    else{
                        str.append(words[j].charAt(i));
                    }
                }
                vertical.add(str.toString().replaceAll("\\s+$", ""));
            }
            return vertical;
        }
    }
}
