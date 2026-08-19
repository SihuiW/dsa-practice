class Solution {
    public boolean canPermutePalindrome(String s) {
        int odd = 1;
        int[] map = new int[26];
        for(char c: s.toCharArray()) {
            map[c - 'a']++;
        }
        for(int i = 0; i < map.length; i++) {
            if(map[i] % 2 != 0) {
                odd--;
            }
            if(odd < 0) return false;
        }
        return true;
    }
}
