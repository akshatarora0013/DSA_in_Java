package Strings.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/long-pressed-name/description/

public class _925_Long_Pressed_Name {
    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            int ptr1 = 0;
            int ptr2 = 0;
            while(ptr1 != name.length() && ptr2 != typed.length()){
                if(name.charAt(ptr1) == typed.charAt(ptr2)){
                    ptr1++;
                    ptr2++;
                }
                else if(ptr2 > 0 && typed.charAt(ptr2) == typed.charAt(ptr2 - 1)){
                    ptr2++;
                }
                else{
                    return false;
                }
            }
            while(ptr2 < typed.length() && typed.charAt(ptr2) == typed.charAt(ptr2 - 1)){
                ptr2++;
            }
            if(ptr1 == name.length() && ptr2 == typed.length()){
                return true;
            }
            return false;
        }
    }
}
