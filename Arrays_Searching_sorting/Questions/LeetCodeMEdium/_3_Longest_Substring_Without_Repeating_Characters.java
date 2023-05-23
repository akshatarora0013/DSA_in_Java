package Arrays_Searching_sorting.Questions.LeetCodeMEdium;
import java.util.*;

//  https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

public class _3_Longest_Substring_Without_Repeating_Characters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s.length() == 0){
                return 0;
            }
            if(s.length() == 1){
                return 1;
            }
            Set<Character> set = new HashSet<>();
            int max = 0;
            for(int i = 0; i < s.length()-1; i++){
                set.add(s.charAt(i));
                int j = i+1;
                while(j < s.length() && !set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    j++;
                }
                max = Math.max(j-i, max);
                set.clear();
            }
            return max;
        }
    }
}
