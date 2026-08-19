class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int p1 = 0, p2 = 0;
        while(p1 < word1.length() && p2 < word2.length()) {
            sb.append(word1.charAt(p1));
            sb.append(word2.charAt(p2));
            p1++;
            p2++;
        }
        if(p1 < word1.length()) {
            sb.append(word1, p1, word1.length());
        }
        if(p2 < word2.length()) {
            sb.append(word2, p2, word2.length());
        }
        return sb.toString();
    }
}