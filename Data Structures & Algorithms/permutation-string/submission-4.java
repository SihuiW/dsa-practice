class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        int[] need = new int[26];
        int[] window = new int[26];
        int l = 0, r = 0;
        for(char c: s1.toCharArray()) need[c - 'a']++;
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
