class Solution {
    public int[] getOrder(int[][] tasks) {
        List<Integer> res = new ArrayList<>();
        int[][] ts = new int[tasks.length][3];
        for(int i = 0; i < tasks.length; i++) {
            ts[i][0] = tasks[i][0];
            ts[i][1] = tasks[i][1];
            ts[i][2] = i;
        }
        Arrays.sort(ts, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });
        long curTime = 0;
        int taskIndex = 0;

        while (res.size() < tasks.length) {
            while (taskIndex < tasks.length && ts[taskIndex][0] <= curTime) {
                pq.offer(ts[taskIndex++]);
            }

            if (!pq.isEmpty()) {
                int[] task = pq.poll();
                res.add(task[2]);
                curTime += task[1];
            } else {
                curTime = ts[taskIndex][0];
            }
        }
        int[] r = new int[tasks.length];
        for(int i = 0; i < tasks.length; i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}