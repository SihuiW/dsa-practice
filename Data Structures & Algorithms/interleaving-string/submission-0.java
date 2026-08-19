class Solution {

    Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return f(s1,s2,s3,0,0);
    }

    boolean f(String s1, String s2, String s3, int p1, int p2) {
        if(p1 == s1.length() && p2 == s2.length()) return true;
        if(memo[p1][p2] != null) return memo[p1][p2];
        int p3 = p1 + p2;
        if(p3 == s3.length()) return p1 == s1.length() && p2 == s2.length();
        if(p1 < s1.length() && s1.charAt(p1) == s3.charAt(p3)) {
            if(f(s1,s2,s3,p1+1,p2)) {
                memo[p1][p2] = true;
                return true;
            }
        }
        if(p2 < s2.length() && s2.charAt(p2) == s3.charAt(p3)) {
            if(f(s1,s2,s3,p1,p2+1)) {
                memo[p1][p2] = true;
                return true;
            }
        }
        return false;
    }
}
