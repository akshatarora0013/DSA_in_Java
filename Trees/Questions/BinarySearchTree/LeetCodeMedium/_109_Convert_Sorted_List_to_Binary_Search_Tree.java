package Trees.Questions.BinarySearchTree.LeetCodeMedium;

import java.util.*;

//  https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

public class _109_Convert_Sorted_List_to_Binary_Search_Tree {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
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
        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while(head != null){
                list.add(head.val);
                head = head.next;
            }
            return sortedArrayToBST(0, list.size()-1, list);
        }
        public TreeNode sortedArrayToBST(int start, int end, List<Integer> list) {
            if(start > end){
                return null;
            }
            int mid = start + (end-start)/2;
            TreeNode node = new TreeNode(list.get(mid));
            node.left = sortedArrayToBST(start, mid-1, list);
            node.right = sortedArrayToBST(mid+1, end, list);
            return node;
        }
    }
}
