package Trees.Questions.BinaryTree.LeetCodeHard;

import java.util.*;

//  https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/

public class _987_Vertical_Order_Traversal_of_a_Binary_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class help {
        TreeNode node;
        int row;
        int col;
        public help(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            TreeMap<Integer , TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
            Queue<help> q = new LinkedList<>();
            q.add(new help(root,0,0));
            while(!q.isEmpty()){
                help queueElement = q.poll();
                TreeNode node = queueElement.node;
                int row = queueElement.row;
                int col = queueElement.col;
                if(!map.containsKey(col)){
                    map.put(col,new TreeMap<>());
                }
                if(!map.get(col).containsKey(row)){
                    map.get(col).put(row, new PriorityQueue<>());
                }
                map.get(col).get(row).add(node.val);
                if(node.left!=null){
                    q.add(new help(node.left, row+1, col-1));
                }
                if(node.right!=null){
                    q.add(new help(node.right, row+1, col+1));
                }

            }
            for (TreeMap < Integer, PriorityQueue<Integer>> tm: map.values()) {
                list.add(new ArrayList<>());
                for (PriorityQueue<Integer> pq: tm.values()) {
                    while (!pq.isEmpty()) {
                        list.get(list.size() - 1).add(pq.poll());
                    }
                }
            }
            return list;
        }
    }
}
