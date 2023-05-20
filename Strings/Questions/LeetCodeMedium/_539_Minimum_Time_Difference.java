package Strings.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/minimum-time-difference/description/

public class _539_Minimum_Time_Difference {
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int totalTimeWindow = 24 * 60;
            int[] occurences = new int[totalTimeWindow];
            Arrays.fill(occurences, -1);

            for(String timePoint: timePoints){
                String[] input = timePoint.split(":");
                int time = Integer.parseInt(input[0])*60 + Integer.parseInt(input[1]);
                if(occurences[time] == 1){
                    return 0;
                }
                occurences[time] = 1;
            }

            int minDiff = Integer.MAX_VALUE;
            int lastTime = -1;
            int latest = Integer.MIN_VALUE;
            int earliest = Integer.MAX_VALUE;

            for(int i = 0; i < totalTimeWindow; i++){
                if(occurences[i] != 1){
                    continue;
                }
                if(lastTime == -1){
                    lastTime = i;
                }
                else{
                    minDiff = Math.min(minDiff, i-lastTime);
                    lastTime = i;
                }
                latest = Math.max(latest, i);
                earliest = Math.min(earliest, i);
            }
            return Math.min(minDiff, 24*60 - (latest-earliest));
        }
    }
}
