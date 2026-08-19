class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}