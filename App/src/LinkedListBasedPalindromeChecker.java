import java.util.*;
public class LinkedListBasedPalindromeChecker {

        static class Node {
            char data;
            Node next;

            Node(char data) {
                this.data = data;
                this.next = null;
            }
        }

        public static void main(String[] args) {

            String str = "madam";

            Node head = null, tail = null;

            for (int i = 0; i < str.length(); i++) {
                Node newNode = new Node(str.charAt(i));
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }

            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            Node prev = null;
            Node curr = slow;

            while (curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node first = head;
            Node second = prev;

            boolean isPalindrome = true;

            while (second != null) {
                if (first.data != second.data) {
                    isPalindrome = false;
                    break;
                }
                first = first.next;
                second = second.next;
            }

            if (isPalindrome) {
                System.out.println("The string is a Palindrome");
            } else {
                System.out.println("The string is NOT a Palindrome");
            }
        }
    }

