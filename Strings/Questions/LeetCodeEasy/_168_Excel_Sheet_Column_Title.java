package Strings.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/excel-sheet-column-title/description/

public class _168_Excel_Sheet_Column_Title {
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder str = new StringBuilder();
            while(columnNumber > 0){
                columnNumber--;
                char c = (char)(columnNumber % 26 + 'A');
                columnNumber /= 26;
                str.append(c);
            }
            str.reverse();
            return str.toString();
        }
    }
}
