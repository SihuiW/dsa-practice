class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m != n) return false;
        int[] s1 = new int[26];
        int[] t1 = new int[26];
        for(int i = 0; i < m; i++) {
            s1[s.charAt(i) - 'a']++;
            t1[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(s1[i] != t1[i]) return false;
        }
        return true;
    }
}
