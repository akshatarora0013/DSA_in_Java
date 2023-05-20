package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/next-greater-node-in-linked-list/

public class _1019_Next_Greater_Node_In_Linked_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            int[] ans = new int[length(head)];
            int index = 0;
            while(head != null && head.next != null){
                ListNode node = head.next;
                while(node != null){
                    if(node.val > head.val){
                        ans[index] = node.val;
                        index++;
                        break;
                    }
                    node = node.next;
                }
                if(node == null && index < ans.length){
                    ans[index] = 0;
                    index++;
                }
                head = head.next;
            }
            return ans;
        }
        public int length(ListNode node){
            int len = 0;
            while(node != null){
                len++;
                node = node.next;
            }
            return len;
        }
    }
}
