package Trees.Questions.LeetCodeMedium;

import java.util.*;

//   https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

public class _114_Flatten_Binary_Tree_to_Linked_List_ {
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
        public void flatten(TreeNode root) {
            if(root == null || root.right == null && root.left == null){
                return;
            }
            flatten(root.left);
            flatten(root.right);
            if(root.left != null){
                TreeNode temp = root.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            return;
        }
    }

}
