package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList_138 {

    //通过map存储节点，保证random的时候不会重复复制
    public Node copyRandomList(Node head) {
        Node p1 = head;
        Map<Node, Node> map = new HashMap<Node, Node>();
        while(p1 != null) {
            map.put(p1, new Node(p1.val));
            p1 = p1.next;
        }

        Node newHead = map.get(head);
        p1 = head;
        Node p2 = newHead;
        while(p1 != null) {
            p2.next = map.get(p1.next);
            p2.random = map.get(p1.random);
            p1 = p1.next;
            p2 = p2.next;
        }
        return newHead;
    }
}
