package com.ds.companies.amazon.leetcode.OA;

class SinglyLinkedListNodeProcessSegment {
    int data;
    SinglyLinkedListNodeProcessSegment next;

    SinglyLinkedListNodeProcessSegment(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AWSServerStructureList {

    public static SinglyLinkedListNodeProcessSegment findLongestList(SinglyLinkedListNodeProcessSegment head) {
        if (head == null || head.next == null) {
            return head;
        }

        SinglyLinkedListNodeProcessSegment maxHead = head;
        SinglyLinkedListNodeProcessSegment currentHead = head;

        int maxLength = 1;
        int currentLength = 1;

        SinglyLinkedListNodeProcessSegment prev = head;
        SinglyLinkedListNodeProcessSegment current = head.next;

        while (current != null) {
            if (current.data <= prev.data) {
                currentLength++;
            } else {
                currentLength = 1;
                currentHead = current;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxHead = currentHead;
            }

            prev = current;
            current = current.next;
        }

        return maxHead;
    }
}
