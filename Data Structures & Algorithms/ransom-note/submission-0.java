class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] m = new int[26];
        int[] r = new int[26];
        for(char c: magazine.toCharArray()) {
            m[c - 'a']++;
        }
        for(char d: ransomNote.toCharArray()) {
            r[d - 'a']++;
        }
        for(int i = 0; i < m.length; i++) {
            if(m[i] < r[i]) return false;
        }
        return true;
    }
}