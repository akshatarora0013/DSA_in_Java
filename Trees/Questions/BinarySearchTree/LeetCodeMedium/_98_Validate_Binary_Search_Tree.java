package Trees.Questions.BinarySearchTree.LeetCodeMedium;

import java.util.*;

//  https://leetcode.com/problems/validate-binary-search-tree/description/

public class _98_Validate_Binary_Search_Tree {
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
        public boolean isValidBST(TreeNode root) {
            return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean help(TreeNode node, long minVal, long maxVal){
            if(node == null){
                return true;
            }
            else if(node.val >= maxVal || node.val <= minVal){
                return false;
            }
            return help(node.left, minVal, node.val) && help(node.right, node.val, maxVal);
        }
    }
}
