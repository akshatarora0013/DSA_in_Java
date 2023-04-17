package Trees.Questions.BinaryTree.LeetCodeEasy;

//  https://leetcode.com/problems/diameter-of-binary-tree/description/

public class _543_Diameter_Of_Binary_Tree_ {
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
        public int diameterOfBinaryTree(TreeNode root) {
            if(root == null){
                return 0;
            }
            int max = 0;
            int rootDiameter = diameter(root);
            int leftDiameter = diameter(root.left);
            int rightDiameter = diameter(root.right);

            if(leftDiameter >= max){
                max = diameterOfBinaryTree(root.left);
            }
            if(rightDiameter >= max){
                max = diameterOfBinaryTree(root.right);
            }
            if(rootDiameter > leftDiameter && rootDiameter > rightDiameter){
                max = rootDiameter;
            }
            return max;
        }
        int height(TreeNode node){
            if(node == null){
                return 0;
            }
            int left = height(node.left);
            int right = height(node.right);
            return Math.max(left,right)+1;
        }
        int diameter(TreeNode node){
            if(node == null){
                return 0;
            }
            return height(node.left)+height(node.right);
        }
    }
}
