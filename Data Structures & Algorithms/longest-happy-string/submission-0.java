class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[][] arr = new int[][]{{'a', a}, {'b', b}, {'c', c}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((d,e) -> e[1] - d[1]);
        for(int[] ar: arr) {
            if(ar[1] > 0) {
                pq.offer(ar);
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            int[] first = pq.poll();
            char d = (char)first[0];
            int n = sb.length();
            if(n >= 2 && sb.charAt(n - 1) == sb.charAt(n - 2) && sb.charAt(n - 1) == d) {
                if(pq.isEmpty()) break;
                int[] second = pq.poll();
                sb.append((char)second[0]);
                if(--second[1] > 0) {
                    pq.offer(second);
                }
                pq.offer(first);
            } else {
                sb.append(d);
                first[1]--;
                if(first[1] > 0) {
                    pq.offer(first);
                }
            }
        }
        return sb.toString();
    }
}