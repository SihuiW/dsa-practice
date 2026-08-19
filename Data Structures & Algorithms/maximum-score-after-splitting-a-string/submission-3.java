class Solution {
    public int maxScore(String s) {
        int ones = 0, zeros = 0, score = 0;
        for(char c: s.toCharArray()) {
            if(c == '1') ones++;
        }

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '1') {
                ones--;
            } else {
                zeros++;
            }
            score = Math.max(score, zeros + ones);
        }

        return score;
    }
}