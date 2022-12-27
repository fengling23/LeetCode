package com.leetcode.linkedlist;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers_2 {
    //总体思路: 诸位相加, 没值补0
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;
            int mod = sum % 10;
            carry = sum/10;

            ListNode curr = new ListNode(mod);
            if(head == null){
                head = tail = curr;
            } else {
                tail.next = curr;
                tail = tail.next;
            }

            if(l1 != null){ l1 = l1.next;}
            if(l2 != null){ l2 = l2.next;}
        }
        //处理最后一位
        if(carry == 1){
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
