package Graph.Questions.LeetCodemedium;
import java.util.*;

//  https://leetcode.com/problems/evaluate-division/description/

public class _399_Evaluate_Division {
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);
            double[] output = new double[queries.size()];
            for(int i = 0; i < queries.size(); i++){
                String dividend = queries.get(i).get(0);
                String divisor =  queries.get(i).get(1);
                if(!graph.containsKey(dividend) || !graph.containsKey(divisor)){
                    output[i] = -1.0;
                }
                else{
                    HashSet<String> visited = new HashSet<>();
                    double[] ans = {-1.0};
                    double temp = 1.0;
                    dfs(dividend, divisor, graph, visited, ans, temp);
                    output[i] = ans[0];
                }
            }
            return output;
        }
        private HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values){
            HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
            for(int i = 0; i < equations.size(); i++){
                String dividend = equations.get(i).get(0);
                String divisor =  equations.get(i).get(1);
                double value = values[i];

                graph.putIfAbsent(dividend, new HashMap<>());
                graph.putIfAbsent(divisor, new HashMap<>());

                graph.get(dividend).put(divisor, value);
                graph.get(divisor).put(dividend, 1.0/value);
            }
            return graph;
        }
        private void dfs(String node, String dest, HashMap<String, HashMap<String, Double>> graph, HashSet<String> visited, double[] ans, double temp){
            if(visited.contains(node)){
                return;
            }
            visited.add(node);
            if(node.equals(dest)){
                ans[0] = temp;
                return;
            }
            for(Map.Entry<String, Double> entry: graph.get(node).entrySet()){
                String newNode = entry.getKey();
                double value = entry.getValue();
                dfs(newNode, dest, graph, visited, ans, temp*value);
            }
        }
    }
}
