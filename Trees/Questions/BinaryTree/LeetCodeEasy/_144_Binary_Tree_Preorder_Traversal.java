package Trees.Questions.BinaryTree.LeetCodeEasy;
import java.util.*;

//   https://leetcode.com/problems/binary-tree-preorder-traversal/description/

public class _144_Binary_Tree_Preorder_Traversal {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            list = new ArrayList<>();
            if(root == null){
                return list;
            }
            dfs(root);
            return list;
        }
        private void dfs(TreeNode node){
            list.add(node.val);
            if(node.left != null){
                dfs(node.left);
            }
            if(node.right != null){
                dfs(node.right);
            }
        }
    }
}
