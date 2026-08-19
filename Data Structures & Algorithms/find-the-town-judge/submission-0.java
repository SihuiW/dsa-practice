class Solution {
    public int findJudge(int n, int[][] trust) {
        List[] graph = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] pair: trust) {
            int a = pair[0];
            int b = pair[1];
            graph[a].add(b);
        }

        int judge = -1;

        for(int i = 1; i <= n; i++) {
            List<Integer> list = graph[i];
            if(list.isEmpty()) {
                judge = i;
                break;
            }
        }
        if(judge == -1) return -1;

        for(int i = 1; i <= n; i++) {
            List<Integer> list = graph[i];
            if(i != judge && !list.contains(judge)) {
                judge = -1;
            }
        }
        return judge;
    }
}