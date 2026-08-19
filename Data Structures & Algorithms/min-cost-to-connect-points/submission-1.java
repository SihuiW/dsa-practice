class Solution {
    public int minCostConnectPoints(int[][] points) {
        int res = 0;
        int n = points.length;
        if (n == 1) return 0;

        boolean[] visited = new boolean[n];
        int[] minCost = new int[n];
        
        // 初始化：所有点到连通集合的距离都是“无穷大”
        Arrays.fill(minCost, Integer.MAX_VALUE);

        // 从0号点开始
        visited[0] = true;
        minCost[0] = 0;
        f(points, 0, visited, minCost);

        // 一共需要加入 n-1 个点
        for (int count = 1; count < n; count++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            // ① 用当前所有已访问的点，更新未访问点的 minCost
            //    （我们每次只用刚刚加入的那个点更新就够了，效率更高）
            //    所以我们先不急着更新，等找到 minIndex 后再更新！

            // ② 找到当前未访问点中，minCost 最小的那个
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minCost[j] < min) {
                    min = minCost[j];
                    minIndex = j;
                }
            }

            // ③ 加到答案
            res += min;
            visited[minIndex] = true;

            // ④ 关键！用刚刚加入的这个点，去更新所有未访问点的距离
            f(points, minIndex, visited, minCost);   // ← 现在传的是正确的新点！
        }

        return res;
    }

    // 修复你的 f 函数：要取 min！不能直接赋值！
    void f(int[][] points, int start, boolean[] visited, int[] minCost) {
        for (int i = 0; i < points.length; i++) {
            if (visited[i]) continue;  // 已访问的跳过
            int dis = Math.abs(points[start][0] - points[i][0]) + 
                      Math.abs(points[start][1] - points[i][1]);
            if (dis < minCost[i]) {    // 关键：取更小的！
                minCost[i] = dis;
            }
        }
    }
}