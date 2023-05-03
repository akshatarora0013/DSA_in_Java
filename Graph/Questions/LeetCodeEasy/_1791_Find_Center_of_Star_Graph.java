package Graph.Questions.LeetCodeEasy;

import java.util.*;

//  https://leetcode.com/problems/find-center-of-star-graph/description/

public class _1791_Find_Center_of_Star_Graph {
    class Solution {
        public int findCenter(int[][] edges) {
            int a = edges[0][0];
            int b = edges[0][1];
            int c = edges[1][0];
            int d = edges[1][1];
            if(a==c) {return a;}
            if(a==d) {return a;}
            if(b==c) {return c;}
            if(b==d) {return b;}
            return 0;
        }
    }
}
