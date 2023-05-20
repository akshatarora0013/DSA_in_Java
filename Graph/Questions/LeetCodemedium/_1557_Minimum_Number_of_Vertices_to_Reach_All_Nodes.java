package Graph.Questions.LeetCodemedium;
import java.util.*;

//  https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/submissions/953099450/

public class _1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes {
    class Solution {
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            boolean[] incomingEdge = new boolean[n];
            for(List<Integer> edge: edges){
                incomingEdge[edge.get(1)] = true;
            }

            List<Integer> minNodes = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(!incomingEdge[i]){
                    minNodes.add(i);
                }
            }

            return minNodes;
        }
    }
}
