package Trees.Questions.BinarySearchTree.LeetCodeMedium;

//  https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/

public class _1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {
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
        public TreeNode bstFromPreorder(int[] preorder) {
            return constructTree(preorder, 0, preorder.length-1);
        }
        private TreeNode constructTree(int[] preorder, int start, int end){
            if(start > end){
                return null;
            }
            TreeNode root = new TreeNode(preorder[start]);
            int i = start;
            while(i <= end && preorder[i] <= root.val){
                i++;
            }
            root.left = constructTree(preorder, start+1, i-1);
            root.right = constructTree(preorder, i, end);
            return root;
        }
    }
}
