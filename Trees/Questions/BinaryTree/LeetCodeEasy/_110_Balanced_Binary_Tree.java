package Trees.Questions.BinaryTree.LeetCodeEasy;

//  https://leetcode.com/problems/balanced-binary-tree/description/

public class _110_Balanced_Binary_Tree {
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
        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }
            if(height(root) == -1){
                return false;
            }
            return true;
        }
        private int height(TreeNode node){
            if(node == null){
                return 0;
            }
            int left = height(node.left);
            int right = height(node.right);
            if(left == -1 || right == -1){
                return -1;
            }
            if(Math.abs(left-right) > 1){
                return -1;
            }
            return Math.max(left, right) + 1;
        }
    }
}
