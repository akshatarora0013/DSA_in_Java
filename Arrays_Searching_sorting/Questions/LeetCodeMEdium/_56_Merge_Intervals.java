package Arrays_Searching_sorting.Questions.LeetCodeMEdium;
import java.util.*;

//  https://leetcode.com/problems/merge-intervals/description/

public class _56_Merge_Intervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            int start = 0;
            int end = 0;
            int i = 0;
            List<List<Integer>> list = new ArrayList<>();
            while(i < intervals.length){
                start = intervals[i][0];
                end = intervals[i][1];
                for(int j = i+1; j < intervals.length; j++){
                    if(intervals[j][0] >= start && intervals[j][0] <= end){
                        end = Math.max(end, intervals[j][1]);
                        i++;
                    }
                    else{
                        break;
                    }
                }
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);
                list.add(temp);
                i++;
            }

            int[][] ans = new int[list.size()][2];
            for(i = 0; i < list.size(); i++){
                ans[i][0] = list.get(i).get(0);
                ans[i][1] = list.get(i).get(1);
            }
            return ans;
        }
    }
}
