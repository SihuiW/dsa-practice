class Solution {
    public int[] frequencySort(int[] nums) {
        int[] record = new int[201];
        for(int i = 0; i < nums.length; i++) {
            record[nums[i] + 100]++;
        }

        int[][] map = new int[201][2];
        for(int i = 0; i < 201; i++) {
            map[i] = new int[]{record[i], i - 100};
        }

        Arrays.sort(map, (a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        int[] res = new int[nums.length];
        int idx = 0;
        for(int i = 0; i < 201; i++) {
            int cnt = map[i][0];
            if(cnt == 0) continue;
            while(cnt > 0) {
                res[idx++] = map[i][1];
                cnt--;
            }
        }

        return res;

    }
}