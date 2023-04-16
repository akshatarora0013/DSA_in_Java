package Trees.Questions.LeetCodeMedium;

import java.util.*;

//   https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_ {
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
        int preOrderIndex;
        Map<Integer, Integer> inorderIndexMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            preOrderIndex = 0;
            inorderIndexMap = new HashMap<>();
            for(int i = 0; i < inorder.length; i++){
                inorderIndexMap.put(inorder[i], i);
            }
            TreeNode root = givingValueToTree(preorder, 0, preorder.length-1);
            return root;
        }
        private TreeNode givingValueToTree(int[] preorder, int start, int end){
            if(start > end){
                return null;
            }
            int rootValue = preorder[preOrderIndex++];
            TreeNode root = new TreeNode(rootValue);
            root.left = givingValueToTree(preorder, start, inorderIndexMap.get(rootValue) -1);
            root.right = givingValueToTree(preorder, inorderIndexMap.get(rootValue) +1, end);
            return root;
        }
    }
}
