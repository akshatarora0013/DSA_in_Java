package Graph.Questions.LeetCodemedium;

import java.util.*;

//   https://leetcode.com/problems/cheapest-flights-within-k-stops/

public class _787_Cheapest_Flights_Within_K_Stops {
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
            for(int i = 0; i < n; i++){
                adj.add(new ArrayList<>());
            }
            for(int i = 0; i < flights.length; i++){
                adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(0, src, 0));

            int[] distance = new int[n];
            for(int i = 0; i < distance.length; i++){
                distance[i] = Integer.MAX_VALUE;
            }
            distance[src] = 0;
            while(!queue.isEmpty()){
                Node it = queue.remove();
                int stops = it.first;
                int node = it.second;
                int cost = it.third;
                if(stops > k){
                    continue;
                }
                for(Pair item: adj.get(node)){
                    int adjNode = item.first;
                    int adjCost = item.second;
                    if(cost + adjCost < distance[adjNode] && stops <= k){
                        distance[adjNode] = cost + adjCost;
                        queue.add(new Node(stops+1, adjNode, cost+adjCost));
                    }
                }
            }
            if(distance[dst] == Integer.MAX_VALUE){
                return -1;
            }
            return distance[dst];
        }
    }
    class Pair{
        int first;
        int second;
        Pair(int node, int cost){
            this.first = node;
            this.second = cost;
        }
    }
    class Node{
        int first;
        int second;
        int third;
        Node(int stops, int node, int cost){
            this.first = stops;
            this.second = node;
            this.third = cost;
        }
    }
}