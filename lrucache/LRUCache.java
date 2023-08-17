package lrucache;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, ListNode> nodeMap;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>(capacity);
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int result = -1;
        ListNode node = nodeMap.get(key);
        if (node != null) {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }
    
    public void put(int key, int value) {
        ListNode node = nodeMap.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
            add(node);
        } else {
            if (nodeMap.size() == capacity) {
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }

            ListNode newNode = new ListNode(key, value);
            add(newNode);
            nodeMap.put(key, newNode);
        }
    }

    public void add(ListNode node) {
        ListNode headNext = head.next;
        head.next = node;
        node.next = headNext;
        node.prev = head;
        headNext.prev = node;

    }

    public void remove(ListNode node) {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
