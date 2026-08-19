class Solution {
    public int leastInterval(char[] tasks, int n) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] times = new int[26];
        for(char c: tasks) {
            times[c - 'A']++;
        }
        for(int t: times) {
            if(t > 0) pq.offer(t);
        }
        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()) {
            list.clear();
            int cycle = 0;
            for (int i = 0; i <= n; i++) {
                int fre = 0;
                if(!pq.isEmpty()) {
                    fre = pq.poll();
                    fre--;
                    cycle++;
                } else {
                    break;
                }
                if(fre > 0) list.add(fre);
            }
            for(int f: list) {
                pq.offer(f);
            }
            if(!pq.isEmpty()) {
                res += n + 1;
            } else {
                res += cycle;
            }
           
        }
        return res;


    }
}
