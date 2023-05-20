package Strings.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/shuffle-string/

public class _1528_Shuffle_String {
    class Solution {
        public String restoreString(String s, int[] indices) {
            StringBuilder str = new StringBuilder(s);
            for(int i = 0; i < indices.length; i++){
                str.setCharAt(indices[i], s.charAt(i));
            }

            return str.toString();
        }
    }
}
