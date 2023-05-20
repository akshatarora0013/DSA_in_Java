package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/description/

public class _1750_Minimum_Length_of_String_After_Deleting_Similar_Ends {
    class Solution {
        public int minimumLength(String s) {
            int len = s.length();
            int i = 0;
            int j = s.length()-1;

            while(i < j){
                if(i > 0 && s.charAt(i) == s.charAt(i-1)){
                    i++;
                    len--;
                    continue;
                }
                if(j < s.length()-1 && s.charAt(j) == s.charAt(j+1)){
                    j--;
                    len--;
                    continue;
                }
                if(s.charAt(i) == s.charAt(j)){
                    i++;
                    j--;
                    len = len-2;
                }
                else{
                    break;
                }
            }
            if(i >0 && i == j && ((s.charAt(i) == s.charAt(i-1)) || (s.charAt(j) == s.charAt(j+1)))){
                len--;
            }
            return len;
        }
    }
}
