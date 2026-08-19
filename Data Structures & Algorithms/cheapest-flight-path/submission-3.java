class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] f: flights) {
            int start = f[0];
            int end = f[1];
            int price = f[2];
            graph.get(start).add(new int[]{end, price});
        }

       
        f(graph, src, dst, k + 1, 0);

        return res == Integer.MAX_VALUE ? -1: res;
    }

    int res = Integer.MAX_VALUE;

    void f(List<List<int[]>> graph, int src, int dst, int k, int pay) {
        if(pay > res) return;
        if(src == dst) {
            res = pay;
            return;
        }

        if(k == 0) return;

        List<int[]> to = graph.get(src);
        for(int[] t: to) {
            int nxt = t[0];
            int price = t[1];
            if(pay + price >= res) continue;
            f(graph, nxt, dst, k - 1, pay + price);
            
        }
    }


}
