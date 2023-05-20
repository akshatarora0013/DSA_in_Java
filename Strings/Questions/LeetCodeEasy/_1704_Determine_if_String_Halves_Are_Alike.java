package Strings.Questions.LeetCodeEasy;

//

public class _1704_Determine_if_String_Halves_Are_Alike {
    class Solution {
        public boolean halvesAreAlike(String s) {
            int first = 0;
            int second = 0;
            for(int i = 0; i < s.length()/2; i++){
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(i+s.length()/2);
                if(ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u' || ch1 == 'A' || ch1 == 'E' || ch1 == 'I' || ch1 == 'O' || ch1 == 'U'){
                    first++;
                }
                if(ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u' || ch2 == 'A' || ch2 == 'E' || ch2 == 'I' || ch2 == 'O' || ch2 == 'U'){
                    second++;
                }
            }
            return first == second;
        }
    }
}
