package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/assign-cookies/
public class _455_Assign_Cookies {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int count = 0;
            int i = 0;
            int j = 0;
            while(i < g.length && j < s.length){
                if(g[i] <= s[j]){
                    count++;
                    i++;
                    j++;
                }
                else{
                    j++;
                }
            }
            return count;
        }
    }
}
