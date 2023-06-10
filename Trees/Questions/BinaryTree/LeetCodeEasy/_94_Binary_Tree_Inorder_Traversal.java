package Trees.Questions.BinaryTree.LeetCodeEasy;
import java.util.*;

//   https://leetcode.com/problems/binary-tree-inorder-traversal/description/

public class _94_Binary_Tree_Inorder_Traversal {
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
        List<Integer> list;
        public List<Integer> inorderTraversal(TreeNode root) {
            list = new ArrayList<>();
            if(root == null){
                return list;
            }
            dfs(root);
            return list;
        }
        private void dfs(TreeNode node){
            if(node.left != null){
                dfs(node.left);
            }
            list.add(node.val);
            if(node.right != null){
                dfs(node.right);
            }
        }
    }
}
