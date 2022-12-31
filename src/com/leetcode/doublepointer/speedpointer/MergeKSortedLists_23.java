package com.leetcode.doublepointer.speedpointer;

import com.leetcode.linkedlist.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists_23 {
    //拆分方法
    public ListNode mergeKLists1(ListNode[] lists) {
        int k = lists.length;
        if (k>0){
            while (k>1){
                int half = (k+1)/2;
                for (int i = 0; i < k/2; i++) {
                    lists[i] = mergeTwoLists1(lists[i], lists[i+half]);
                    //free space
                    lists[i+half] = null;
                }
                k = half;
            }
            return lists[0];
        } else {
            //处理空数组
            return null;
        }
    }

    //递归拆分
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;
        return helper(lists, 0, lists.length-1);
    }

    private ListNode helper(ListNode[] lists, int left, int right) {
        if (right == left) return lists[left];
        if (right - left == 1) return mergeTwoLists1(lists[left],lists[right]);
        int mid = left + (right - left) / 2;
        ListNode leftNode = helper(lists, left, mid);
        ListNode rightNode = helper(lists, mid+1, right);
        return mergeTwoLists1(leftNode, rightNode);
    }

    //快慢指针的while写法
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while(list1 != null && list2 != null) {

            if(list1.val > list2.val) {
                p.next = list2;
                list2 = list2.next;
            } else {
                p.next = list1;
                list1 = list1.next;
            }
            p = p.next;
        }
        p.next = list1 != null ? list1 : list2;
        return dummy.next;
    }

    //快慢指针的递归写法
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 ==null) return list2;
        if (list2 ==null) return list1;
        if(list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1,list2.next);
            return list2;
        }
    }

    //最小堆解法, 利用优先级队列
    public ListNode mergeKLists3(ListNode[] lists) {
        int k = lists.length;
        if (k == 0 ) {return null;}
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(k, (a,b) -> { return a.val -b.val; });
        for (int i = 0; i < k; i++) {
            //加入每个链表的头结点
            if (lists[i] != null) queue.offer(lists[i]);
        }

        ListNode head = new ListNode(-1), current = head;
        while (!queue.isEmpty()) {
            //拿出最小的
            ListNode smallest = queue.poll();
            current.next = smallest;
            //将最小的next节点加入queue,重新构建最小堆
            if(smallest.next != null) queue.offer(smallest.next);
            current = current.next;
        }
        return head.next;
    }
    
}
