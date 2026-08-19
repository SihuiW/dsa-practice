class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(String s: strs) {
                if(i == s.length() || s.charAt(i) != c) {
                    return s.substring(0,i);
                }
            }
        }
        return strs[0];
        
    }
}