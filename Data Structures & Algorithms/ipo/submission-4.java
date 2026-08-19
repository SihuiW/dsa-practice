class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> minH = new PriorityQueue<>((a,b) -> capital[a] - capital[b]);
        PriorityQueue<Integer> maxH = new PriorityQueue<>((a,b) -> profits[b] - profits[a]);

        for(int i = 0; i < capital.length; i++) {
            minH.offer(i);
        }

        for(int i = 0; i < k; i++) {
            while(!minH.isEmpty() && capital[minH.peek()] <= w) {
                maxH.offer(minH.poll());
            }
            if(!maxH.isEmpty()) {
                w += profits[maxH.poll()];
            }
        }
        return w;
    }
}