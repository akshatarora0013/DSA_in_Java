package Trees.Questions.BinarySearchTree.LeetCodeMedium;

import java.util.*;

//  https://leetcode.com/problems/delete-node-in-a-bst/description/

public class _450_Delete_Node_in_a_BST {
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null){
                return null;
            }
            if(root.val == key){
                if(root.left == null && root.right == null ){
                    return null;
                }
                else if(root.left == null && root.right != null){
                    TreeNode temp = root.right;
                    root.val = temp.val;
                    root.left = temp.left;
                    root.right = temp.right;
                    return root;
                }
                else if(root.left != null && root.right == null){
                    TreeNode temp = root.left;
                    root.val = temp.val;
                    root.left = temp.left;
                    root.right = temp.right;
                    return root;
                }
            }
            remove(root, null, false, key);
            return root;
        }
        private void remove(TreeNode node, TreeNode parent, boolean ilc, int item){
            if(node == null){
                return;
            }
            if(node.val > item){
                remove(node.left, node, true, item);
            }
            else if(node.val < item){
                remove(node.right, node, false, item);
            }
            //reched the element which we want to remove
            else{
                if(node.left == null && node.right == null){
                    if(ilc){
                        parent.left = null;
                    }
                    else{
                        parent.right = null;
                    }
                }
                else if(node.left == null && node.right != null){
                    if(ilc){
                        parent.left = node.right;
                    }
                    else{
                        parent.right = node.right;
                    }
                }
                else if(node.left != null && node.right == null){
                    if(ilc){
                        parent.left = node.left;
                    }
                    else{
                        parent.right = node.left;
                    }
                }
                else{
                    int min = min(node.right);
                    node.val = min;
                    remove(node.right, node, false, min);
                }
            }
        }
        private int min(TreeNode node){
            if(node.left == null){
                return node.val;
            }
            return min(node.left);
        }
    }
}
