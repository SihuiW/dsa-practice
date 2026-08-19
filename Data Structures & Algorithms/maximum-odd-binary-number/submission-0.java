class Solution {
    public String maximumOddBinaryNumber(String s) {
        int one = 0;
        for(char c: s.toCharArray()) {
            if(c == '1') {
                one++;
            }
        }
        int zero = s.length() - one;
        StringBuilder sb = new StringBuilder();
        while(one > 1) {
            sb.append(1);
            one--;
        }
        while(zero > 0) {
            sb.append(0);
            zero--;
        }
        if(one > 0) sb.append(1);
        return sb.toString();
    }
}