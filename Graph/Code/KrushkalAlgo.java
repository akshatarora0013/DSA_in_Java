package Graph.Code;

import java.util.*;

//  https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree

public class KrushkalAlgo {
    class Solution{
        public int spanningTree(int V, int E, int edges[][]){
            List<Edge> adj = new ArrayList<>();
            for(int[] edge: edges){
                int Node = edge[0];
                int adjNode = edge[1];
                int wt = edge[2];
                adj.add(new Edge(Node, adjNode, wt));
            }
            Collections.sort(adj,(a,b)->a.weight-b.weight);
            DisjointSet ds = new DisjointSet(V);
            int mstWt = 0;
            for(int i = 0; i < adj.size(); i++){
                int u = adj.get(i).src;
                int v = adj.get(i).dst;
                int wt = adj.get(i).weight;

                if(ds.findParent(u) != ds.findParent(v)){
                    mstWt = mstWt + wt;
                    ds.unionBySize(u, v);
                }
            }
            return mstWt;
        }

    }
    class Edge{
        int src;
        int dst;
        int weight;
        Edge(int src, int dst, int weight){
            this.src = src;
            this.dst = dst;
            this.weight = weight;
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
