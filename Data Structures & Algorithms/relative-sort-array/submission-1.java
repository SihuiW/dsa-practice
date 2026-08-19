class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[arr1.length];
        for(int a: arr1) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int idx = 0;
        for(int a2: arr2) {
            int times = map.get(a2);
            while(times > 0) {
                res[idx++] = a2;
                times--;
            }
            map.remove(a2);
        }
        int remainingCount = arr1.length - idx;
        int[] temp = new int[remainingCount];
        int k = 0;
        for(int e: map.keySet()) {
            int times = map.get(e);
            while(times > 0) {
                temp[k++] = e;
                times--;
            }
        }
        Arrays.sort(temp);
        int j = 0;
        for(int i = idx; i < res.length; i++) {
            res[i] = temp[j++];
        }
        return res;
    }
}