package basicStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ReverseAString {

    public static void main(String[] args) {
        List<Character> str =
                new ArrayList<>(Arrays.asList('h', 'e', 'l', 'l', 'o'));

        // Creating an instance of Solution class
        ReverseAString sol = new ReverseAString();

        // Function call to reverse the string
        sol.reverseString(str);

        for (char c : str) {
            System.out.print(c);
        }

        List<Character> str2 =
                new ArrayList<>(Arrays.asList('h', 'e', 'l', 'l', 'o'));
        sol.reverseStringStriverEditorialBruteForce(str2);
        System.out.println();
        for (char c : str2) {
            System.out.print(c);
        }

    }

    public void reverseString(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        String reversed = new String(arr);
        System.out.println(reversed);
    }

    public void reverseString(List<Character> s) {
        //your code goes here
        for(int l = 0, r = s.size() - 1; l<r; l++,r--) {
            char temp = s.get(l);
            s.set(l, s.get(r));
            s.set(r, temp);

            //or simply use
            Collections.swap(s, l, r);
        }
    }

    public void reverseStringStriverEditorialBruteForce(List<Character> s) {
        Stack<Character> stack = new Stack<>();

        // Push characters onto the stack
        for (char c : s) {
            stack.push(c);
        }

        // Pop characters from the stack to reverse the string
        for (int i = 0; i < s.size(); ++i) {
            s.set(i, stack.pop());
        }
    }

    public void reverseStringStriverEditorialOptimal(List<Character> s) {
        int start = 0, end = s.size() - 1;

        // Until the string is reversed
        while (start < end) {
            // Swap the characters at start and end
            char ch = s.get(start);
            s.set(start, s.get(end));
            s.set(end, ch);

            // Move the pointers towards the center
            start++;
            end--;
        }
    }
}
