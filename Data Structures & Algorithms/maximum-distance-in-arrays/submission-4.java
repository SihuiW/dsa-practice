class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // 当前最大值 - 以前最小值
        // 当前最小值 - 以前最大值
        int gmin = arrays.get(0).get(0);
        int gmax = arrays.get(0).get(arrays.get(0).size()- 1);
        int res = 0;

        for(int i = 1; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            int cmin = list.get(0);
            int cmax = list.get(list.size() - 1);
            res = Math.max(res, Math.max(gmax - cmin, cmax - gmin));
            gmin = Math.min(gmin, cmin);
            gmax = Math.max(gmax, cmax);
        }
        
        return res;
    }
}
