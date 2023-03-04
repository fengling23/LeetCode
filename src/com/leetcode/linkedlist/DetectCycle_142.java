package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle_142 {

    //利用hashset判断有无next指针指向之前的节点
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            //add不为true则证明已存在
            if (!set.add(p)) return p;
            p=p.next;
        }
        return null;
    }

    // 假设快慢指针相遇时，慢指针slow走了k步，那么快指针fast一定走了2k步：
    // fast一定比slow多走了k步，这多走的k步其实就是fast指针在环里转圈圈，所以k的值就是环长度的「整数倍」
    // 假设相遇点距环的起点的距离为m，那么结合上图的 slow 指针，环的起点距头结点head的距离为k - m，也就是说如果从head前进k - m步就能到达环起点。
    // 如果从相遇点继续前进k - m步，也恰好到达环起点

    public ListNode detectCycle1(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)  break;
        }
        if (fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast){
            slow = slow.next; fast = fast.next;
        }
        return slow;
    }
}
