class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        char[] c = s.toCharArray();
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(f(c, i, j)) res++;
            }
        }
        return res;
    }

    boolean f(char[] c, int i, int j) {
        while(i <= j) {
            if(c[i] == c[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
