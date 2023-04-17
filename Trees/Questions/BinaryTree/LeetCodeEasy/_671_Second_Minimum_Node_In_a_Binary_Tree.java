package Trees.Questions.BinaryTree.LeetCodeEasy;

import java.util.*;

//  https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/

public class _671_Second_Minimum_Node_In_a_Binary_Tree {
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
        boolean flag = false;
        public int findSecondMinimumValue(TreeNode root) {
            Set<Integer> values = new HashSet<Integer>();
            traverse(root, values);

            int min = root.val;
            int secondMin = Integer.MAX_VALUE;
            for(int value : values){
                if(min < value && value <= secondMin){
                    secondMin = value;
                    flag = true;
                }
            }
            if(flag){
                return secondMin;
            }
            return -1;
        }
        void traverse(TreeNode node, Set<Integer> values){
            if(node == null){
                return;
            }
            values.add(node.val);
            traverse(node.left, values);
            traverse(node.right, values);
        }
    }
}
