class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length;
        int m = secondList.length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(secondList[j][0] <= firstList[i][1] && secondList[j][1] >= firstList[i][0]) {
                    int a = Math.max(firstList[i][0], secondList[j][0]);
                    int b = Math.min(firstList[i][1], secondList[j][1]);
                    list.add(new int[]{a, b});
                }
            }
        }
        int[][] res = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}