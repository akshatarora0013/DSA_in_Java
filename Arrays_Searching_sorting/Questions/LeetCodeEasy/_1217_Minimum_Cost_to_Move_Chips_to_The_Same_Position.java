package Arrays_Searching_sorting.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/

public class _1217_Minimum_Cost_to_Move_Chips_to_The_Same_Position {
    class Solution {
        public int minCostToMoveChips(int[] position) {
            int even = 0;
            int odd = 0;
            for(int i = 0; i < position.length; i++){
                if(position[i] % 2 == 0){
                    even++;
                }
                else{
                    odd++;
                }
            }
            if(even<odd){
                return even;
            }
            return odd;
        }
    }
}
