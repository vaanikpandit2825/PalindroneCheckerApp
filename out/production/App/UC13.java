import java.util.*;

public class UseCase13PalindromeCheckerApp {

    public static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return str.equals(reversed);
    }

    public static boolean dequePalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    public static boolean twoPointerPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        long start1 = System.nanoTime();
        boolean result1 = stackPalindrome(normalized);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = dequePalindrome(normalized);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean result3 = twoPointerPalindrome(normalized);
        long end3 = System.nanoTime();

        System.out.println("Stack Approach Result: " + result1 + " Time: " + (end1 - start1) + " ns");
        System.out.println("Deque Approach Result: " + result2 + " Time: " + (end2 - start2) + " ns");
        System.out.println("Two Pointer Approach Result: " + result3 + " Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}