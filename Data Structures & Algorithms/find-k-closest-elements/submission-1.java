class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<int[]> list = new ArrayList<>();
        for(int n: arr) {
            list.add(new int[]{Math.abs(n - x), n});
        }
        list.sort((a,b) -> a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            res.add(list.get(i)[1]);
        }
        Collections.sort(res);
        return res;
    }
}