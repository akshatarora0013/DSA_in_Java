package Graph.Questions.LeetCodemedium;

import java.util.*;

//   https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

public class _1976_Number_of_Ways_to_Arrive_at_Destination {
    class Solution {
        static int mod = (int)(Math.pow(10, 9)+7);
        class Pair{
            int node;
            int cost;
            Pair(int node, int cost){
                this.node = node;
                this.cost = cost;
            }
        }
        public int countPaths(int n, int[][] roads) {
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for(int i = 0; i < n; i++){
                adj.add(new ArrayList<>());
            }
            for(int[] road: roads){
                adj.get(road[0]).add(new Pair(road[1], road[2]));
                adj.get(road[1]).add(new Pair(road[0], road[2]));
            }
            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[0] = 0;
            int[] ways = new int[n];
            ways[0] = 1;

            PriorityQueue<Pair> queue = new PriorityQueue<Pair>((x, y) -> x.cost - y.cost);
            queue.add(new Pair(0, 0));

            while(!queue.isEmpty()){
                Pair first = queue.poll();
                for(Pair p: adj.get(first.node)){
                    if(p.cost + first.cost < distance[p.node]){
                        distance[p.node] = p.cost + first.cost;
                        queue.offer(new Pair(p.node, distance[p.node]));
                        ways[p.node] = ways[first.node];
                    }
                    else if(p.cost + first.cost == distance[p.node]){
                        ways[p.node] = (ways[p.node] + ways[first.node]) % mod;
                    }
                }
            }
            return ways[n-1] % mod;
        }
    }
}
