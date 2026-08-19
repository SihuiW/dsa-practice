class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int allToA = 0;
        for(int i = 0; i < costs.length; i++) {
            allToA += costs[i][0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0; i < costs.length; i++) {
            pq.add(costs[i][0] - costs[i][1]);   
        }
        for(int i = 0; i < costs.length / 2; i++) {
            allToA -= pq.poll();
        }
        return allToA;
    }
}