package Trees.Questions.BinarySearchTree.LeetCodeMedium;

import java.util.*;

//   https://leetcode.com/problems/recover-binary-search-tree/

public class _99_Recover_Binary_Search_Tree {
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
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        public void recoverTree(TreeNode root) {
            if(root == null){
                return;
            }
            inOrder(root);
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        void inOrder(TreeNode node){
            if(node == null){
                return;
            }
            inOrder(node.left);
            if(prev != null && node.val < prev.val){
                if(first == null){
                    first = prev;
                }
                second = node;
            }
            prev = node;
            inOrder(node.right);
        }
    }
}
