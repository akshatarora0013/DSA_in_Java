package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/split-linked-list-in-parts/description/

public class _725_Split_Linked_List_in_Parts {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            ListNode curr = head;
            int n = 0;
            while(curr != null){
                curr = curr.next;
                n++;
            }

            int size = n/k;
            int rem = n%k;

            ListNode[] nodes = new ListNode[k];
            curr = head;
            for(int i = 0; i < k; i++){
                ListNode node = new ListNode(0);
                ListNode temp = node;
                int newSize;
                if(i < rem){
                    newSize = size + 1;
                }
                else{
                    newSize = size;
                }
                for(int j = 0; j < newSize; j++){
                    temp.next = new ListNode(curr.val);
                    temp = temp.next;
                    if(curr != null){
                        curr = curr.next;
                    }
                }
                nodes[i] = node.next;
            }
            return nodes;
        }
    }
}
