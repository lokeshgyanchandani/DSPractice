package com.ds.companies.amazon.leetcode.OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SinglyLinkedListNode {
    String item;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(String item) {
        this.item = item;
        this.next = null;
    }
}

public class ShoppingCartSinglyLinkedListNode {
    public static SinglyLinkedListNode getShoppingCart(SinglyLinkedListNode head,
                                                       List<List<String>> queries) {
        for (List<String> query : queries) {
            String action = query.get(0);

            if (action.equals("PUSH_HEAD")) {
                String itemName = query.get(1);
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(itemName);
                newNode.next = head;
                head = newNode;
            } else if (action.equals("PUSH_TAIL")) {
                String itemName = query.get(1);
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(itemName);

                if (head == null) {
                    head = newNode;
                } else {
                    SinglyLinkedListNode current = head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newNode;
                }
            } else if (action.equals("POP_HEAD") && head != null) {
                head = head.next;
            }
        }

        return head;
    }

    public static void printList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.item + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head = null;
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("PUSH_HEAD", "apple"));
        queries.add(Arrays.asList("PUSH_TAIL", "banana"));
        queries.add(Arrays.asList("PUSH_HEAD", "orange"));
        queries.add(Arrays.asList("POP_HEAD"));

        head = getShoppingCart(head, queries);
        printList(head);
    }
}
