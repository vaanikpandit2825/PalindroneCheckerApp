import java.util.*;
public class StackAndQueueBasedPalindromeCheck {
        public static void main(String[] args) {

            String str = "madam";

            Stack<Character> stack = new Stack<>();
            Queue<Character> queue = new LinkedList<>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                stack.push(ch);
                queue.add(ch);
            }

            boolean isPalindrome = true;

            for (int i = 0; i < str.length(); i++) {
                if (queue.remove() != stack.pop()) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                System.out.println("The string is a Palindrome");
            } else {
                System.out.println("The string is NOT a Palindrome");
            }
        }
    }

