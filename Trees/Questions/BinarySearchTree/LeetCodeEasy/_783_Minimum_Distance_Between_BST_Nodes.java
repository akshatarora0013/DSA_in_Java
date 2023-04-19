package Trees.Questions.BinarySearchTree.LeetCodeEasy;

import java.util.*;

//   https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

public class _783_Minimum_Distance_Between_BST_Nodes {
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

    class Solution {
        public int minDiffInBST(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            int min = Integer.MAX_VALUE;
            for(int i = 1; i < list.size(); i++){
                if(list.get(i) - list.get(i-1) < min){
                    min = list.get(i) - list.get(i-1);
                }
            }
            return min;
        }
        public void inOrder(TreeNode node, List<Integer> list){
            if(node == null){
                return;
            }
            inOrder(node.left,list);
            list.add(node.val);
            inOrder(node.right,list);
            return;
        }
    }
}
