class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] arr = new int[profits.length][2];
        for(int i = 0; i < arr.length; i++) {
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }
        PriorityQueue<int[]> minC = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        PriorityQueue<int[]> maxP = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        for(int[] pair: arr) {
            minC.offer(pair);
        }

        while(k > 0) {
            while(!minC.isEmpty() && minC.peek()[1] <= w) {
                maxP.offer(minC.poll());
            }
            if(maxP.isEmpty()) break;
            int[] p = maxP.poll();
            w += p[0];
            k--;
        }
        return w;

    }
}