package Strings.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/description/

public class _1309_Decrypt_String_from_Alphabet_to_Integer_Mapping {
    class Solution {
        public String freqAlphabets(String s) {
            StringBuilder str = new StringBuilder();
            int i = 0;
            while(i < s.length()){
                if(i+2 < s.length() && s.charAt(i+2) == '#'){
                    int num = Integer.parseInt(s.substring(i, i+2));
                    str.append((char)('j' + num - 10));
                    i = i+3;
                }
                else{
                    int num = s.charAt(i) - '0';
                    str.append((char)('a' + num - 1));
                    i++;
                }
            }
            return str.toString();
        }
    }
}
