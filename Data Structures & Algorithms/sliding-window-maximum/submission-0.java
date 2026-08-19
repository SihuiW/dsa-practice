class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> window = new LinkedList<>();
        List<Integer> collection = new ArrayList<>();
        int l = 0, r = 0;
        while(r < nums.length) {
            int n = nums[r];
            window.add(n);
            r++;
            while(window.size() == k) {
                int max = Integer.MIN_VALUE;
                for(int c: window) {
                    max = Math.max(max, c);
                }
                collection.add(max);
                window.removeFirst();
            }

        }
        int[] res = new int[collection.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = collection.get(i);
        }
        return res;
    }
}
