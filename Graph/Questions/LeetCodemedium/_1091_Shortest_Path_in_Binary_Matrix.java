package Graph.Questions.LeetCodemedium;

import java.util.*;

//    https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

public class _1091_Shortest_Path_in_Binary_Matrix {
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if(grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1){
                return -1;
            }
            if(grid.length-1 == 0){
                return 1;
            }
            int[][] distance = new int[grid.length][grid.length];
            for(int i = 0; i < distance.length; i++){
                for(int j = 0; j < distance.length; j++){
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(1, 0, 0));
            grid[0][0] = 0;
            int[] delRow = {1, 0, -1, 0, -1, 1, -1, 1};
            int[] delCol = {0, 1, 0, -1, -1, 1, 1, -1};
            while(queue.size() != 0){
                int dis = queue.peek().distance;
                int nodei = queue.peek().i;
                int nodej = queue.peek().j;
                queue.remove();

                for(int i = 0; i < 8; i++){
                    int newi = nodei + delRow[i];
                    int newj = nodej + delCol[i];

                    if(newi >= 0 && newj >= 0 && newi < grid.length && newj < grid.length && grid[newi][newj] == 0 && dis+1 < distance[newi][newj]){
                        distance[newi][newj] = dis+1;
                        if(newi == grid.length-1 && newj == grid.length-1){
                            return dis+1;
                        }
                        queue.add(new Node(dis+1, newi, newj));
                    }
                }
            }

            return -1;
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
