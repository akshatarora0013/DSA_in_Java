package Trees.Questions.BinaryTree.LeetCodeHard;

import java.util.*;

//  https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

public class _124_Binary_Tree_Maximum_Path_Sum {
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
        int maxSum;
        public int maxPathSum(TreeNode root) {
            maxSum = Integer.MIN_VALUE;
            pathSum(root);
            return maxSum;
        }
        int pathSum(TreeNode node){
            if(node == null){
                return 0;
            }
            int leftSum = Math.max(pathSum(node.left) , 0);
            int rightSum = Math.max(pathSum(node.right) , 0);
            maxSum = Math.max(maxSum, leftSum + rightSum + node.val);

            return Math.max(leftSum + node.val , rightSum + node.val);
        }
    }
}
