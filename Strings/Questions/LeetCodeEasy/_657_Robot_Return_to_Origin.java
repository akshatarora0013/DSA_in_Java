package Strings.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/robot-return-to-origin/description/

public class _657_Robot_Return_to_Origin {
    class Solution {
        public boolean judgeCircle(String moves) {
            int row = 0;
            int col = 0;
            for(int i = 0; i < moves.length(); i++){
                char ch = moves.charAt(i);
                if(ch == 'U'){
                    row--;
                }
                else if(ch == 'D'){
                    row++;
                }
                else if(ch == 'R'){
                    col++;
                }
                else if(ch == 'L'){
                    col--;
                }
            }
            if(row == 0 && col == 0){
                return true;
            }
            return false;
        }
    }
}
