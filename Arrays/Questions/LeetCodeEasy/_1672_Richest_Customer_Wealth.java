package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/richest-customer-wealth/

public class _1672_Richest_Customer_Wealth {
    class Solution {
        public int maximumWealth(int[][] accounts) {
            int max = 0;
            for(int i = 0; i < accounts.length; i++){
                int sum = 0;
                for(int j = 0; j < accounts[i].length; j++){
                    sum = sum + accounts[i][j];
                }
                if(sum > max){
                    max = sum;
                }
            }
            return max;
        }
    }
}
