package middlell;

import ListNode.ListNode;

class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        double middle = length / 2;
        for (int i = 0; i < Math.ceil(middle); i++) {
            head = head.next;
        }

        return head;
    }
}
