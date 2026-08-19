class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];
            int[] last = res.get(res.size() - 1);
            if(start <= last[1]) {
                last[0] = Math.min(start, last[0]);
                last[1] = Math.max(end, last[1]);
                res.set(res.size() - 1, last);
            } else if(start > last[1]) {
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
