package Trees.Questions.BinaryTree.LeetCodeEasy;

//  https://leetcode.com/problems/cousins-in-binary-tree/description/

public class _993_Cousins_in_Binary_Tree {
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
        public boolean isCousins(TreeNode root, int x, int y) {
            int[][] parents = new int[2][2];
            parent(root, x, y, 0, 1,parents);
            if(parents[0][0] != parents[1][0] && parents[0][1] == parents[1][1]){
                return true;
            }
            return false;
        }
        int[][] parent(TreeNode node, int x, int y, int parent, int level, int[][] ans){
            if(node == null){
                return ans;
            }
            if(node.val == x){
                ans[0][0] = parent;
                ans[0][1] = level;
            }
            if(node.val == y){
                ans[1][0] = parent;
                ans[1][1] = level;
            }
            level++;
            parent(node.left, x, y, node.val, level, ans);
            parent(node.right, x, y, node.val, level, ans);
            return ans;
        }
    }
}
