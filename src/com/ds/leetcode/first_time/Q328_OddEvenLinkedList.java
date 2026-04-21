package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

public class Q328_OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode rightHead = head.next;

        ListNode left = head;
        ListNode right = head.next;

        while (right != null) {
            if (right.next != null) {
                left.next = right.next;
                left = left.next;

                right.next = right.next.next;
            }

            right = right.next;
        }

        left.next = rightHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        Q328_OddEvenLinkedList obj = new Q328_OddEvenLinkedList();
        ListUtil.printList(obj.oddEvenList(head));
    }
}
