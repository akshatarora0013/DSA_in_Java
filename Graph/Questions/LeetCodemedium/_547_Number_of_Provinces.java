package Graph.Questions.LeetCodemedium;

import java.util.*;

//  https://leetcode.com/problems/number-of-provinces/description/

public class _547_Number_of_Provinces {
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int count = 0;
            boolean[] visited = new boolean[isConnected.length];
            for(int i = 0; i < visited.length; i++){
                if(!visited[i]){
                    count++;
                    dfs(i, isConnected, visited);
                }
            }
            return count;
        }
        public void dfs(int node, int[][] isConnected, boolean[] visited) {
            visited[node] = true;
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[node][i] == 1 && !visited[i]) {
                    dfs(i, isConnected, visited);
                }
            }
        }
    }

    // using Disjoint Set
//    class Solution {
//        public int findCircleNum(int[][] Connected) {
//            DisjointSet ds = new DisjointSet(Connected.length);
//            for(int i = 0; i < Connected.length; i++){
//                for(int j = 0; j < Connected.length; j++){
//                    if(Connected[i][j] == 1){
//                        ds.unionByRank(i, j);
//                    }
//                }
//            }
//            int count = 0;
//            for(int i = 0; i < Connected.length; i++){
//                if(ds.findParent(i) == i){
//                    count++;
//                }
//            }
//            return count;
//        }
//    }
//    class DisjointSet {
//        List<Integer> rank = new ArrayList<>();
//        List<Integer> parent = new ArrayList<>();
//        List<Integer> size = new ArrayList<>();
//        DisjointSet(int n){
//            for(int i = 0; i <= n; i++){
//                rank.add(0);
//                parent.add(i);
//                size.add(1);
//            }
//        }
//
//        int findParent(int node){
//            if(node == parent.get(node)){
//                return node;
//            }
//            int ultimateParent = findParent(parent.get(node));
//            parent.set(node, ultimateParent);
//            return ultimateParent;
//        }
//
//        void unionByRank(int u, int v){
//            int ultimateParentU = findParent(u);
//            int ultimateParentV = findParent(v);
//            if(ultimateParentU == ultimateParentV){
//                return;
//            }
//            if(rank.get(ultimateParentU) < rank.get(ultimateParentV)){
//                parent.set(ultimateParentU, ultimateParentV);
//            }
//            else if(rank.get(ultimateParentV) < rank.get(ultimateParentU)){
//                parent.set(ultimateParentV, ultimateParentU);
//            }
//            else{
//                parent.set(ultimateParentV, ultimateParentU);
//                rank.set(ultimateParentU, rank.get(ultimateParentU)+1);
//            }
//        }
//    }
}
