class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int[] itv: intervals) {
            pq.add(itv);
        }
        Stack<int[]> stk = new Stack<>();
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(stk.isEmpty()) {
                stk.push(cur);
            } else {
                int[] prev = stk.pop();
                if(cur[0] < prev[1]) {
                    stk.push(new int[]{prev[0], Math.min(cur[1], prev[1])});
                } else {
                    stk.push(prev);
                    stk.push(cur);
                }
            }
        }
        return intervals.length - stk.size();
    }
}
