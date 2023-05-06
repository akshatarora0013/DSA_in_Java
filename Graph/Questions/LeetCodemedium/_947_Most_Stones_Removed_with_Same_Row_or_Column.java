package Graph.Questions.LeetCodemedium;

import java.util.*;

//  https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/

public class _947_Most_Stones_Removed_with_Same_Row_or_Column {
    class Solution {
        public int removeStones(int[][] stones) {
            int maxRow = 0;
            int maxCol = 0;
            for(int[] stone: stones){
                maxRow = Math.max(maxRow, stone[0]);
                maxCol = Math.max(maxCol, stone[1]);
            }
            DisjointSet ds = new DisjointSet(maxRow+maxCol+1);
            HashMap<Integer, Integer> stoneNodes = new HashMap<>();
            for(int[] stone: stones){
                int nodeRow = stone[0];
                int nodeCol = stone[1]+maxRow+1;
                ds.unionBySize(nodeRow, nodeCol);
                stoneNodes.put(nodeRow, 1);
                stoneNodes.put(nodeCol, 1);
            }
            int count = 0;
            for(Map.Entry<Integer, Integer> it: stoneNodes.entrySet()){
                if(ds.findParent(it.getKey()) == it.getKey()){
                    count++;
                }
            }
            return stones.length - count;
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
