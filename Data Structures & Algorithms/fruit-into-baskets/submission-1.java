class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> window = new HashMap<>();
        int l = 0, r = 0;
        int res = 0;
        while(r < fruits.length) {
            int rf = fruits[r++];
            window.put(rf, window.getOrDefault(rf, 0) + 1);
            while(window.size() > 2) {
                int lf = fruits[l];
                window.put(lf, window.get(lf) - 1);
                if(window.get(lf) == 0) {
                    window.remove(lf);
                }
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}