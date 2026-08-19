class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;
        char[] chars = s.toCharArray();
        int index = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            int a = f(chars, i, i);
            int b = f(chars, i, i + 1);
            if(a > b) {
                if(a > max) {
                    index = i - a / 2;
                    max = a;
                }
            } else {
                if(b > max) {
                    index = i - b / 2 + 1;
                    max = b;
                }
            }
        }
        return s.substring(index, index + max);
    }

    //以ij为中心向两侧辐射，看看最长能到多少
    int f(char[] chars, int i, int j) {
        int res = (i == j) ? -1 : 0;
        while(i >= 0 && j < chars.length) {
            if(chars[i] == chars[j]) {
                i--;
                j++;
                res += 2;
            } else {
                break;
            }
        }
        return res;
    }
}
