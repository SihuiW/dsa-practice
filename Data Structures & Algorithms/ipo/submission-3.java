class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> maxP = new PriorityQueue<>((a, b) -> profits[b] - profits[a]);
        PriorityQueue<Integer> minC = new PriorityQueue<>((a, b) -> capital[a] - capital[b]);
        
        for (int i = 0; i < capital.length; i++) {
            minC.offer(i);
        }

        while(k > 0) {
            while(!minC.isEmpty() && capital[minC.peek()] <= w) {
                maxP.offer(minC.poll());
            }
            if(maxP.isEmpty()) break;
            w += profits[maxP.poll()];
            k--;
        }
        return w;
    }
}