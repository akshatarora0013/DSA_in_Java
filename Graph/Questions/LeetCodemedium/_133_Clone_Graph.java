package Graph.Questions.LeetCodemedium;

import java.util.*;

//  https://leetcode.com/problems/clone-graph/description/

public class _133_Clone_Graph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        public Node cloneGraph(Node node) {
            if(node == null){
                return null;
            }
            Node[] processed = new Node[101];
            Node graph = new Node(node.val);
            Arrays.fill(processed , null);
            copyList(node, graph, processed);
            return graph;
        }
        public void copyList(Node node, Node copy, Node[] processed){
            processed[node.val] = copy;
            for(Node temp: node.neighbors){
                if(processed[temp.val] == null){
                    Node newNode = new Node(temp.val);
                    copy.neighbors.add(newNode);
                    copyList(temp, newNode, processed);
                }
                else{
                    copy.neighbors.add(processed[temp.val]);
                }
            }
        }
    }
}
