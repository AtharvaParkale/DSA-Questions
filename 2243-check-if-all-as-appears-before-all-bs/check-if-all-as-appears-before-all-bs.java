class Solution {
public boolean checkString(String s) {
    boolean seenB = false;

    for (int i = 0; i < s.length(); i++) {
        char curr = s.charAt(i);

        if (curr == 'b') {
            seenB = true;
        } else if (seenB) {
            return false;
        }
    }

    return true;
}
}