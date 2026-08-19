class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        for(int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }
        while(k > 0) {
            int[] cur = pq.poll();
            pq.add(new int[]{cur[0] * multiplier, cur[1]});
            k--;
        }
        int[] res = new int[nums.length];
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            res[cur[1]] = cur[0];
        }
        return res;



    }
}