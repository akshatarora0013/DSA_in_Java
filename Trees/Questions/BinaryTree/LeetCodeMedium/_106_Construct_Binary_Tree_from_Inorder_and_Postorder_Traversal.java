package Trees.Questions.BinaryTree.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
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
        int postOrderIndex;
        Map<Integer, Integer> map;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            postOrderIndex = postorder.length-1;
            map = new HashMap<>();
            for(int i = 0; i < inorder.length; i++){
                map.put(inorder[i], i);
            }
            return tree(postorder, 0, postorder.length-1);
        }
        private TreeNode tree(int[] postorder, int start, int end){
            if(start > end){
                return null;
            }
            int rootValue = postorder[postOrderIndex--];
            TreeNode root = new TreeNode(rootValue);
            root.right = tree(postorder, map.get(rootValue) +1, end);
            root.left = tree(postorder, start, map.get(rootValue) - 1);
            return root;
        }

    }
}
