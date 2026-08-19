class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        for(String w: words) {
            boolean is = true;
            for(char c: w.toCharArray()) {
                if(allowed.indexOf(c) == -1) {
                    is = false;
                }
            }
            if(is) res++;
        }
        return res;
    }
}