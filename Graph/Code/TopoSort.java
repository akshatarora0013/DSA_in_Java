package Graph.Code;

import java.util.*;

//  https://practice.geeksforgeeks.org/problems/topological-sort/1

public class TopoSort {
//    DFS WAY

//    class Solution {
//        private static void dfs(int node, int vis[], Stack<Integer> st,
//                                ArrayList<ArrayList<Integer>> adj) {
//            vis[node] = 1;
//            for (int it : adj.get(node)) {
//                if (vis[it] == 0)
//                    dfs(it, vis, st, adj);
//            }
//            st.push(node);
//        }
//
//        // Function to return list containing vertices in Topological order.
//        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
//            int vis[] = new int[V];
//            Stack<Integer> st = new Stack<Integer>();
//            for (int i = 0; i < V; i++) {
//                if (vis[i] == 0) {
//                    dfs(i, vis, st, adj);
//                }
//            }
//
//            int ans[] = new int[V];
//            int i = 0;
//            while (!st.isEmpty()) {
//                ans[i++] = st.peek();
//                st.pop();
//            }
//            return ans;
//        }
//    }

    // BFS WAY (Kahn's Algo)

//    class Solution {
//        // Function to return list containing vertices in Topological order.
//        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
//            int indegree[] = new int[V];
//            for (int i = 0; i < V; i++) {
//                for (int it : adj.get(i)) {
//                    indegree[it]++;
//                }
//            }
//
//            Queue<Integer> q = new LinkedList<Integer>();
//            ;
//            for (int i = 0; i < V; i++) {
//                if (indegree[i] == 0) {
//                    q.add(i);
//                }
//            }
//
//            int topo[] = new int[V];
//            int i = 0;
//            while (!q.isEmpty()) {
//                int node = q.peek();
//                q.remove();
//                topo[i++] = node;
//                // node is in your topo sort
//                // so please remove it from the indegree
//
//                for (int it : adj.get(node)) {
//                    indegree[it]--;
//                    if (indegree[it] == 0) {
//                        q.add(it);
//                    }
//                }
//            }
//
//            return topo;
//        }
//    }

}
