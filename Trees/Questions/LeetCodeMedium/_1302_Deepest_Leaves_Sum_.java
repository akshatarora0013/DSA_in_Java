package Trees.Questions.LeetCodeMedium;

import java.util.*;

//  https://leetcode.com/problems/deepest-leaves-sum/description/

public class _1302_Deepest_Leaves_Sum_ {
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
        public int deepestLeavesSum(TreeNode root) {
            int rootHeight = height(root);
            return calculateSum(root, rootHeight);
        }
        int calculateSum(TreeNode node, int rootHeight){
            if(node == null){
                return 0;
            }
            if(rootHeight == 1){
                return node.val;
            }
            rootHeight--;
            return calculateSum(node.left, rootHeight) + calculateSum(node.right, rootHeight);

        }

        private int height(TreeNode node){
            if(node == null){
                return 0;
            }
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }
}
