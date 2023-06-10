package Trees.Questions.BinaryTree.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/binary-tree-postorder-traversal/submissions/956246999/

public class _145_Binary_Tree_Postorder_Traversal {
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
        public List<Integer> postorderTraversal(TreeNode root) {
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
            if(node.right != null){
                dfs(node.right);
            }
            list.add(node.val);
        }
    }
}
