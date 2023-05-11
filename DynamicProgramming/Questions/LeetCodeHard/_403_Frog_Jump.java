package DynamicProgramming.Questions.LeetCodeHard;

import java.util.*;

//   https://leetcode.com/problems/frog-jump/description/

public class _403_Frog_Jump {
    class Solution {
        public boolean canCross(int[] stones) {
            Map<Integer, Map<Integer, Boolean>> dp = new HashMap<>();
            for(int stone: stones){
                dp.put(stone, new HashMap<>());
            }
            return checkCross(dp, 0, 1, stones[stones.length-1]);
        }
        private boolean checkCross(Map<Integer, Map<Integer, Boolean>> dp, int currentStone, int jump, int targetStone){
            if(currentStone == targetStone){
                return true;
            }
            else if(!dp.containsKey(currentStone) || jump == 0){
                return false;
            }
            else if(dp.containsKey(currentStone) && dp.get(currentStone).containsKey(jump)){
                return dp.get(currentStone).get(jump);
            }
            else{
                boolean ans1 = checkCross(dp, currentStone+jump, jump-1, targetStone);
                boolean ans2 = checkCross(dp, currentStone+jump, jump, targetStone);
                boolean ans3 = checkCross(dp, currentStone+jump, jump+1, targetStone);
                dp.get(currentStone).put(jump, ans1 || ans2 || ans3);
                return dp.get(currentStone).get(jump);
            }
        }
    }
}
