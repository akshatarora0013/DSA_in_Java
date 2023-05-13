package StackAndQueues.Questions.LeetCodeMedium;
import java.util.*;

//   https://leetcode.com/problems/decode-string/description/

public class _394_Decode_String {
    class Solution {
        public String decodeString(String s) {
            Stack<Integer> nums = new Stack<>();
            Stack<StringBuilder> string = new Stack<>();

            StringBuilder str = new StringBuilder();
            int num = 0;
            for(char ch: s.toCharArray()){
                if(ch >= '0' && ch <= '9'){
                    num = (num*10) + ch - '0';
                }
                else if(ch == '['){
                    nums.push(num);
                    num = 0;
                    string.push(str);
                    str = new StringBuilder();
                }
                else if(ch == ']'){
                    StringBuilder temp = str;
                    str = string.pop();
                    int count = nums.pop();
                    while(count > 0){
                        str.append(temp);
                        count--;
                    }
                }
                else{
                    str.append(ch);
                }
            }
            return str.toString();
        }
    }
}
