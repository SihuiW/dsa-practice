class Solution {
    public int appendCharacters(String s, String t) {
        if(s.contains(t)) return 0;
        int p1 = 0, p2 = 0;
        while(p1 < s.length() && p2 < t.length()) {
            if(s.charAt(p1) == t.charAt(p2)) {
                p1++;
                p2++;
            } else {
                p1++;
            }
        }
        return t.length() - p2;
    }
}