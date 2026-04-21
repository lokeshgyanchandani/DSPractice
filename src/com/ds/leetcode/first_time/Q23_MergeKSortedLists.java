package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q23_MergeKSortedLists {

    static Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));

    static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0), tail = head;

        for (ListNode node : lists) if (node != null) heap.offer(node);

        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) heap.offer(tail.next);
        }

        return head.next;
    }

    public static void main(String[] args) {

    }
}
