class Solution {
    public String largestGoodInteger(String num) {
        char res = ' ';
        for(int i = 2; i < num.length(); i++) {
            if(num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                if(num.charAt(i) > res) {
                    res = num.charAt(i);
                }
            }
        }

        return res == ' ' ? "" : "" + res + res + res;
    }
}