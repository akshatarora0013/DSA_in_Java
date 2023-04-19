package Trees.Questions.BinaryTree.LeetCodeMedium;

import java.util.*;

//  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q){
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if(left == null){
                return right;
            }
            else if(right == null){
                return left;
            }
            else{
                return root;
            }
        }
    }
}
