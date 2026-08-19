class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] need = new int[26];
        int[] window = new int[26];
        for(char a: s1.toCharArray()) {
            need[a - 'a']++;
        }
        int l = 0, r = 0;
        while(r < s2.length()) {
            char c = s2.charAt(r++);
            window[c - 'a']++;
            if(r - l > s1.length()) {
                char d = s2.charAt(l++);
                window[d - 'a']--;
            }
            if(Arrays.equals(need, window)) return true;
        }
        return false;
    }
}
