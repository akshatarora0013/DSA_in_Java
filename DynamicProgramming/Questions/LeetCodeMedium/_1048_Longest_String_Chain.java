package DynamicProgramming.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/longest-string-chain/description/

public class _1048_Longest_String_Chain {
    class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words, Comparator.comparingInt(String::length));
            int[] dp = new int[words.length];
            int max = 1;
            Arrays.fill(dp, 1);
            for(int i = 0; i < words.length; i++){
                for(int prev = 0; prev < i; prev++){
                    if(check(words[i], words[prev]) && 1+dp[prev] > dp[i]){
                        dp[i] = 1+dp[prev];
                    }
                }
                if(dp[i] > max){
                    max = dp[i];
                }
            }
            return max;
        }
        private boolean check(String s1, String s2){
            if(s1.length() != s2.length() + 1){
                return false;
            }
            int first = 0;
            int second = 0;
            while(first < s1.length()){
                if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                    first++;
                    second++;
                }
                else{
                    first++;
                }
            }
            if(first == s1.length() && second == s2.length()){
                return true;
            }
            return false;
        }
    }
}
