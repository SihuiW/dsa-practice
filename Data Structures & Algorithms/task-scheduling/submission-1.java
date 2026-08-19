class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Deque<int[]> cool = new ArrayDeque<>();
        for (int freq : map.values()) {
            pq.offer(freq);
        }
        while (!pq.isEmpty() || !cool.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int cnt = pq.poll();
                cnt--;
                if (cnt > 0) {
                    cool.offer(new int[] {cnt, time + n});
                }
            }
            if (!cool.isEmpty() && cool.peek()[1] == time) {
                pq.offer(cool.poll()[0]);
            }
        }
        return time;
    }
}
