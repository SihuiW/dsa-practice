class Solution {
    public int shortestWay(String source, String target) {
        int p1 = 0, p2 = 0, res = 0;
        while (p1 < target.length()) {
            int old = p1;

            while (p2 < source.length()) {
                if (target.charAt(p1) == source.charAt(p2)) {
                    p1++;
                    if (p1 == target.length())
                        break;
                }
                p2++;
            }

            if (old == p1)
                return -1;

            res++;
            p2 = 0;
        }
        return res;
    }
}
