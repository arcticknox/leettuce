/**
 * Definition for singly-linked list.
 */
 function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
 const reverseList = function(head) {
    let prev = null;
    let curr = head;
    while (curr != null) {
        let nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
};

const head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));

console.log(reverseList(head));