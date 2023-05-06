package Greedy.LeetCodeMedium;

//   https://leetcode.com/problems/dota2-senate/description/

public class _649_Dota2_Senate {
    class Solution {
        public String predictPartyVictory(String senate) {
            StringBuilder senateArray = new StringBuilder(senate);
            int rCount = 0;
            int dCount = 0;
            for (int i = 0; i < senateArray.length(); i++) {
                if (senateArray.charAt(i) == 'R') {
                    rCount++;
                } else {
                    dCount++;
                }
            }
            boolean[] ban = new boolean[senate.length()];
            int index = 0;
            while(rCount != 0 && dCount != 0){
                if(!ban[index]){
                    if(senateArray.charAt(index) == 'R'){
                        banned(senateArray, 'D', (index+1)%senateArray.length(), ban);
                        dCount--;
                    }
                    else{
                        banned(senateArray, 'R', (index+1)%senateArray.length(), ban);
                        rCount--;
                    }
                }
                index = (index+1)%senateArray.length();
            }
            if(rCount > 0){
                return "Radiant";
            }
            return "Dire";
        }
        private void banned(StringBuilder senateArray, char toBan, int index, boolean[] ban){
            while(true){
                if(senateArray.charAt(index) == toBan && !ban[index]){
                    ban[index] = true;
                    break;
                }
                index = (index + 1)% senateArray.length();
            }
        }
    }
}
