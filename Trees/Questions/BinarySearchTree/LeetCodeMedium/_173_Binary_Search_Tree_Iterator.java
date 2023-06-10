package Trees.Questions.BinarySearchTree.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/binary-search-tree-iterator/description/

public class _173_Binary_Search_Tree_Iterator {
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

    class BSTIterator {
        List<Integer> inorder;
        int index;

        public BSTIterator(TreeNode root) {
            index = 0;
            inorder = new ArrayList<>();
            dfs(root);
        }

        public int next() {
            if(hasNext()){
                int element = inorder.get(index);
                index++;
                return element;
            }
            return -1;
        }

        public boolean hasNext() {
            if(index < inorder.size()){
                return true;
            }
            return false;
        }

        private void dfs(TreeNode node){
            if(node == null){
                return;
            }
            dfs(node.left);
            inorder.add(node.val);
            dfs(node.right);
        }
    }
}
