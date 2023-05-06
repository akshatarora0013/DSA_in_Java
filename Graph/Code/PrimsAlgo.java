package Graph.Code;

import java.util.*;

//   https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree

public class PrimsAlgo {
    class Pair implements Comparable<Pair>{
        int wt;
        int v;
        Pair(int v, int wt){
            this.v=v;
            this.wt=wt;
        }
        public int compareTo(Pair that){
            return this.wt-that.wt;
        }
    }

    class Solution{
        public int spanningTree(int V, int E, int edges[][]){
            boolean vis[]=new boolean[V];
            PriorityQueue<Pair> pq=new PriorityQueue<>();
            pq.add(new Pair(0,0));
            int ans=0;
            ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<Pair>());
            }
            for(int i=0;i<edges.length;i++){
                adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
                adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
            }
            while(pq.size()!=0){
                Pair cur=pq.remove();

                int v=cur.v;
                if(vis[v]){
                    continue;
                }
                ans+=cur.wt;
                vis[v]=true;
                for(Pair e:adj.get(v)){
                    if(!vis[e.v]){
                        pq.add(new Pair(e.v,e.wt));
                    }
                }
            }
            return ans;
        }
    }
}
