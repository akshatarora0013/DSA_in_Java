package Trees.Questions.BinaryTree.LeetCodeEasy;

//   https://leetcode.com/problems/symmetric-tree/description/

public class _101_Symmetric_Tree {
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
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }
            return symm(root.left, root.right);
        }
        private boolean symm(TreeNode node1, TreeNode node2){
            if(node1 == null && node2 == null){
                return true;
            }
            if(node1 == null || node2 == null){
                return false;
            }
            if(node1.val == node2.val){
                return symm(node1.left, node2.right) && symm(node1.right, node2.left);
            }
            else{
                return false;
            }
        }
    }
}
