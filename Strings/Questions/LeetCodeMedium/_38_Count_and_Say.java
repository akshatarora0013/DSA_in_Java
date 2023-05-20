package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/count-and-say/description/

public class _38_Count_and_Say {
    class Solution {
        public String countAndSay(int n) {
            String prev = "1";
            for(int i = 2; i <= n; i++){
                String current = cas(prev);
                prev = current;
            }
            return prev;
        }
        private String cas(String str){
            StringBuilder s = new StringBuilder();
            char prev = str.charAt(0);
            int count = 1;
            for(int i = 1; i < str.length(); i++){
                char curr = str.charAt(i);
                if(curr != prev){
                    s.append(Integer.toString(count));
                    s.append(prev);
                    prev = curr;
                    count = 1;
                }
                else{
                    count++;
                }
            }
            s.append(Integer.toString(count));
            s.append(prev);
            return s.toString();
        }
    }
}
