class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> profitsMaxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < profits.length; i++) {
            available.add(new int[]{capital[i], profits[i]});
        }

        while(k > 0) {
            while(!available.isEmpty() && available.peek()[0] <= w) {
                profitsMaxHeap.offer(available.poll()[1]);
            }
            if(profitsMaxHeap.isEmpty()) return w;
            w += profitsMaxHeap.poll();
            k--;
        }

        return w;

    }
}