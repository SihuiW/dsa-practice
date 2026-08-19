class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            list.add(new int[]{Math.abs(arr[i] - x), i});
        }
        list.sort((a,b) -> a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            res.add(arr[list.get(i)[1]]);
        }
        Collections.sort(res);
        return res;
    }
}