package Graph.Questions.LeetCodeHard;

import java.util.*;

//   https://leetcode.com/problems/making-a-large-island/solutions/

public class _827_Making_A_Large_Island {
    class Solution {
        public int largestIsland(int[][] grid) {
            DisjointSet ds = new DisjointSet(grid.length * grid.length);
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, -1, 0, 1};
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid.length; j++){
                    if(grid[i][j] == 1){
                        for(int k = 0; k < 4; k++){
                            int newRow = i + dRow[k];
                            int newCol = j + dCol[k];
                            if(newRow >= 0 && newRow < grid.length && newCol >=0 && newCol < grid.length && grid[newRow][newCol] == 1){
                                ds.unionBySize(i*grid.length + j, newRow*grid.length + newCol);
                            }
                        }
                    }
                }
            }

            int max = 0;
            boolean bool = true;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid.length; j++){
                    if(grid[i][j] == 0){
                        bool = false;
                        Set<Integer> set = new HashSet<>();
                        for(int k = 0; k < 4; k++){
                            int newRow = i + dRow[k];
                            int newCol = j + dCol[k];
                            if(newRow >= 0 && newRow < grid.length && newCol >=0 && newCol < grid.length && grid[newRow][newCol] == 1){
                                set.add(ds.findParent(newRow*grid.length + newCol));
                            }
                        }
                        int sizeTotal = 0;
                        for(int element: set){
                            sizeTotal = sizeTotal + ds.size.get(element);
                        }
                        max = Math.max(sizeTotal+1, max);
                    }
                }
            }
            if(bool){
                return grid.length*grid.length;
            }
            return max;
        }
    }
    class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        DisjointSet(int n){
            for(int i = 0; i <= n; i++){
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        int findParent(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ultimateParent = findParent(parent.get(node));
            parent.set(node, ultimateParent);
            return ultimateParent;
        }
        void unionByRank(int u, int v){
            int ultimateParentU = findParent(u);
            int ultimateParentV = findParent(v);
            if(ultimateParentU == ultimateParentV){
                return;
            }
            if(rank.get(ultimateParentU) < rank.get(ultimateParentV)){
                parent.set(ultimateParentU, ultimateParentV);
            }
            else if(rank.get(ultimateParentV) < rank.get(ultimateParentU)){
                parent.set(ultimateParentV, ultimateParentU);
            }
            else{
                parent.set(ultimateParentV, ultimateParentU);
                rank.set(ultimateParentU, rank.get(ultimateParentU)+1);
            }
        }

        void unionBySize(int u, int v){
            int ultimateParentU = findParent(u);
            int ultimateParentV = findParent(v);
            if(ultimateParentU == ultimateParentV){
                return;
            }
            if(size.get(ultimateParentU) < size.get(ultimateParentV)){
                parent.set(ultimateParentU, ultimateParentV);
                size.set(ultimateParentV, size.get(ultimateParentU) + size.get(ultimateParentV));
            }
            else{
                parent.set(ultimateParentV, ultimateParentU);
                size.set(ultimateParentU, size.get(ultimateParentU) + size.get(ultimateParentV));
            }
        }
    }
}
