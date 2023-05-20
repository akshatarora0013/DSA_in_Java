package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/repeated-string-match/description/

public class _686_Repeated_String_Match {
    class Solution {
        public int repeatedStringMatch(String a, String b) {
            String str = "";
            int count = 0;
            while(!str.contains(b) && str.length() < b.length()+a.length()){
                str = str + a;
                count++;
            }
            if(str.contains(b)){
                return count;
            }
            return -1;
        }
    }
}
