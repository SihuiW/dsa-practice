class Solution {
    public char findTheDifference(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        int p1 = 0, p2 = 0;
        while(p1 < s.length() && p2 < t.length()) {
            if(sc[p1] != tc[p2]) return tc[p2];
            p1++;
            p2++;
        }
        return tc[p2];
    }
}