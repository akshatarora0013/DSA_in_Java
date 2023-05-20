package LinkedList.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/linked-list-random-node/description/

public class _382_Linked_List_Random_Node {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        private ArrayList<Integer> range = new ArrayList<>();

        public Solution(ListNode head) {
            while(head != null){
                this.range.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            int pick = (int)(Math.random() * this.range.size());
            return this.range.get(pick);
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
}
