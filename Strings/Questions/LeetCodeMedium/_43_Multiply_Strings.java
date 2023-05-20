package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/multiply-strings/description/

public class _43_Multiply_Strings {
    class Solution {
        public String multiply(String num1, String num2) {
            int[] pos = new int[num1.length() + num2.length()];
            for(int i = num1.length()-1; i >= 0; i--){
                for(int j = num2.length()-1; j >= 0; j--){
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    int p1 = i + j;
                    int p2 = i + j + 1;
                    int sum = mul+ pos[p2];
                    pos[p1] += sum/10;
                    pos[p2] = sum%10;
                }
            }
            StringBuilder ans = new StringBuilder();
            for(int p: pos){
                if(!(ans.length() == 0 && p == 0)){
                    ans.append(p);
                }
            }
            if(ans.length() == 0){
                return "0";
            }
            return ans.toString();
        }
    }
}
