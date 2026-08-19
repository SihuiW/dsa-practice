class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for(int[] interval: intervals) {
            pq.add(interval);
        }
        pq.add(newInterval);

        Stack<int[]> stk = new Stack<>();
        while(!pq.isEmpty()) {
            if(stk.isEmpty()) {
                stk.push(pq.poll());
            } else {
                int[] pre = stk.peek();
                int[] cur = pq.poll();
                if(cur[0] <= pre[1]) {
                    stk.pop();
                    int[] interval = new int[]{pre[0], Math.max(pre[1], cur[1])};
                    stk.push(interval);
                } else {
                    stk.push(cur);
                }
            }

        }
        int[][] res = new int[stk.size()][2];
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = stk.pop();
        }
        return res;
    }
}