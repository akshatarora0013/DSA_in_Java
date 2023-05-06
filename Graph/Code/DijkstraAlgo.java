package Graph.Code;

import java.util.*;

//  https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-dijkstra-set-1-adjacency-matrix

public class DijkstraAlgo {
    //  Using Priority Queue
    class Solution
    {
        //Function to find the shortest distance of all the vertices
        //from the source vertex S.
        public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
        {
            int[] distance= new int[V];
            for(int i = 0; i < V; i++){
                distance[i] = Integer.MAX_VALUE;
            }
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
            pq.add(new Pair(0, S));
            distance[S] = 0;
            while(pq.size() != 0){
                int dis = pq.peek().distance;
                int node = pq.peek().node;
                pq.remove();

                for(int i = 0; i < adj.get(node).size(); i++){
                    int weight = adj.get(node).get(i).get(1);
                    int adjNode = adj.get(node).get(i).get(0);

                    if(dis + weight < distance[adjNode]){
                        distance[adjNode] = dis + weight;
                        pq.add(new Pair(distance[adjNode], adjNode));
                    }
                }
            }
            return distance;
        }
    }
    class Pair{
        int distance;
        int node;
        Pair(int distance, int node){
            this.distance= distance;
            this.node = node;
        }
    }



}
