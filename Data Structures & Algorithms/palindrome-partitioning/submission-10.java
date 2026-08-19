class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int n = s.length();
        //从i...j是不是回文
        boolean[][] dp = new boolean[n][n];
        
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        f(s, 0, new ArrayList<>(), dp);

        return res;
    }

    void f(String s, int start, List<String> path, boolean[][] dp) {
        if(start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int end = start; end < s.length(); end++) {
            if(dp[start][end]) {
                path.add(s.substring(start, end + 1));
                f(s, end + 1, path,dp);
                path.remove(path.size() - 1);
            }
        }
    }



}
