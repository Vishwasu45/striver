package basicStrings;

public class IsomorphicString {

    public static void main(String[] args) {
        IsomorphicString obj = new IsomorphicString();
        String s = "apple";
        String t = "bbnbm";
        System.out.println(obj.isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapS[charS] != mapT[charT]) {
                return false;
            }

            mapS[charS] = i + 1;
            mapT[charT] = i + 1;
        }
        return true;
    }
}
