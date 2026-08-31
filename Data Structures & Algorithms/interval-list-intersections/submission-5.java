class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> list = new ArrayList<>();

        int p1 = 0, p2 = 0;
        while(p1 < firstList.length && p2 < secondList.length) {
            int[] a1 = firstList[p1];
            int[] a2 = secondList[p2];
            
            int s = Math.max(a1[0], a2[0]);
            int e = Math.min(a1[1], a2[1]);
            
            if(s <= e) {
                list.add(new int[]{s, e});  
            } 
            if(a1[1] < a2[1]) {
                p1++;
            } else {
                p2++;
            }
        }

        int[][] res = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}