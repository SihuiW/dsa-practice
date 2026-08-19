class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int[] res = new int[arr1.length];
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for(int n: arr2) {
            if(map.containsKey(n)) {
                int cnt = map.get(n);
                while(cnt > 0) {
                    res[idx++] = n;
                    cnt--;
                }
                map.remove(n);
            }
        }
        for (int key : map.keySet()) {
            int cnt = map.get(key);
            while(cnt > 0) {
                list.add(key);
                cnt--;
            }
        }
        Collections.sort(list);
        int k = 0;
        while (idx < arr1.length) {
            res[idx++] = list.get(k++);
        }
        return res;

    }
}