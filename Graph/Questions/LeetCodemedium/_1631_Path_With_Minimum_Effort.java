package Graph.Questions.LeetCodemedium;

import java.util.*;

//    https://leetcode.com/problems/path-with-minimum-effort/description/

public class _1631_Path_With_Minimum_Effort {
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int[][] distance = new int[heights.length][heights[0].length];
            for(int i = 0; i < distance.length; i++){
                for(int j = 0; j < distance[0].length; j++){
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
            distance[0][0] = 0;
            PriorityQueue<Node> queue = new PriorityQueue<Node>((x,y) -> x.distance - y.distance);
            queue.add(new Node(0, 0, 0));
            int[] delRow = {0, -1, 0, 1};
            int[] delCol = {-1, 0, 1, 0};
            while(queue.size() != 0){
                Node it = queue.remove();
                int diff = it.distance;
                int row = it.i;
                int col = it.j;

                if(row == heights.length-1 && col == heights[0].length-1){
                    return diff;
                }
                for(int i = 0; i < 4; i++){
                    int newr = row + delRow[i];
                    int newc = col + delCol[i];

                    if(newr>=0 && newc >=0 && newr < heights.length && newc < heights[0].length){
                        int newEffort = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), diff);
                        if(newEffort < distance[newr][newc]) {
                            distance[newr][newc] = newEffort;
                            queue.add(new Node(newEffort, newr, newc));
                        }
                    }
                }
            }
            return 0;
        }
    }
    class Node{
        int distance;
        int i;
        int j;
        Node(int distance, int i, int j){
            this.distance = distance;
            this.i = i;
            this.j = j;
        }
    }
}
