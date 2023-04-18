package Trees.Questions.BinarySearchTree.LeetCodeEasy;

import java.util.*;

//  https://leetcode.com/problems/range-sum-of-bst/description/

public class _938_Range_Sum_of_BST {
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
        public int rangeSumBST(TreeNode root, int low, int high) {
            return sum(root, low, high);
        }
        int sum(TreeNode node, int low, int high){
            if(node == null){
                return 0;
            }
            if(node.val >= low && node.val <= high){
                return node.val+sum(node.left, low, high)+sum(node.right, low, high);
            }
            if(node.val <= low){
                return sum(node.right, low, high);
            }
            if(node.val >= high){
                return sum(node.left, low, high);
            }
            return 0;
        }
    }
}
