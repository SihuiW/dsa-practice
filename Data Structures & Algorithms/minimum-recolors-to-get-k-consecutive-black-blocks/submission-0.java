class Solution {
    public int minimumRecolors(String blocks, int k) {
        int window = 0;
        for(int i = 0; i < k; i++) {
            if(blocks.charAt(i) == 'W') {
                window++;
            }
        }
        int res = window;
        int l = 0, r = k;
        while(r < blocks.length()) {
            char c = blocks.charAt(r);
            r++;
            if(c == 'W') {
                window++;
            }
            if(blocks.charAt(l) == 'W') {
                window--;
            }
            l++;
            res = Math.min(res, window);
        }

        return res;

    }
}