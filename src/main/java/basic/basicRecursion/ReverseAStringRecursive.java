package basic.basicRecursion;

import java.util.ArrayList;
import java.util.List;

public class ReverseAStringRecursive {

    public static void main(String[] args) {
        ReverseAStringRecursive rsr = new ReverseAStringRecursive();
        ArrayList<Character> s = new ArrayList<>();
        s.add('h');
        s.add('e');
        s.add('l');
        s.add('l');
        s.add('o');
        System.out.println(rsr.reverseString(s));
    }

    public List<Character> reverseString(ArrayList<Character> s) {
        recursiveSwap(0, s.size() - 1, s);
        return s;
    }

    private void recursiveSwap(int left, int right, ArrayList<Character> s) {
        if (left >= right) {
            return;
        }
        char temp = s.get(left);
        s.set(left, s.get(right));
        s.set(right, temp);

        recursiveSwap(left + 1, right - 1, s);
    }
}
