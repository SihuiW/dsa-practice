class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        String vowel = "aeiou";
        int n = words.length;
        int[] prefix = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            boolean isV = vowel.indexOf(words[i - 1].charAt(0)) != -1 && vowel.indexOf(words[i - 1].charAt(words[i - 1].length() - 1)) != -1;
            prefix[i] = prefix[i - 1] + (isV == true ? 1: 0);
        }

        int[] res = new int[queries.length];
        int idx = 0;

        for(int[] q: queries) {
            int l = q[0];
            int r = q[1];
            res[idx++] = prefix[r + 1] - prefix[l];
        }
        return res;
    }
}