class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];
            int lastEnd = list.get(list.size() - 1)[1];
            if(start >= lastEnd) {
                list.add(interval);
            } else {
                if(end < lastEnd) {
                    list.remove(list.size() - 1);
                    list.add(interval);
                }
            }
        }
        return intervals.length - list.size();
    }
}
